package com.heim.netty;

import com.heim.models.auth.Auth;
import com.heim.models.bind.Bind;
import com.heim.models.client.*;
import io.netty.channel.ChannelId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: sbenner
 * Date: 3/1/17
 * Time: 3:00 PM
 */

public class XmppStreamReader {


    private static final Logger logger = LoggerFactory.getLogger(XmppStreamReader.class);


    private static String buildXmlString(String xmlstring) {
        String xml = null;
        if ((xmlstring.startsWith("<?xml") || xmlstring.contains("<stream:stream"))
                && !xmlstring.contains("</stream:stream>")) {
            xml = xmlstring += "</stream:stream>";
        } else if (xmlstring.contains("</stream:stream>")
                && !xmlstring.contains("<stream:stream")) {
            xml = "<stream:stream>" + xmlstring;
        }

        if (!xmlstring.startsWith("<?xml"))
            xml = "<xmpp>" + xmlstring + "</xmpp>";

        return xml;
    }

    static boolean validate(String xmlstring) {
        boolean isValid = false;
        try {

            xmlstring = buildXmlString(xmlstring);

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader =
                    factory.createXMLStreamReader(
                            new ByteArrayInputStream(xmlstring.getBytes()));
            while (reader.hasNext()) {
                reader.next();
            }
            isValid = true;
        } catch (Exception ex) {
            logger.info("ERRORED " + xmlstring);
            logger.error(ex.getMessage(), ex);
        }
        return isValid;
    }

    static List<Object> read(String xmlstring, ChannelId channelId) {


        List<Object> objects = new ArrayList<>();

        if (xmlstring.trim().startsWith("<starttls xmlns=")) {

            objects.add("<proceed xmlns='urn:ietf:params:xml:ns:xmpp-tls'/>");
            return objects;

        }


        xmlstring = buildXmlString(xmlstring);


        logger.info("XML READER: " + xmlstring);

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader =
                    factory.createXMLStreamReader(
                            new ByteArrayInputStream(xmlstring.getBytes()));

            //keep track of thread ids
            Message msg = null;
            String tagContent = null;
            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        logger.info("localname: " + reader.getLocalName());
                        switch (reader.getLocalName()) {
                            case "stream":
                                objects.add(makeStream(reader));
                                break;
                            case "auth":
                                Auth a = new Auth();
                                for (int i = 0; i < reader.getAttributeCount(); i++) {
                                    String name = reader.getAttributeLocalName(i);
                                    String val = reader.getAttributeValue(i);
                                    switch (name) {
                                        case "mechanism":
                                            a.setMechanism(val);
                                            break;
                                    }
                                }
                                objects.add(a);
                                break;
                            case "session":
                                Optional optionalIq =
                                        objects.stream().filter(
                                                i -> i instanceof Iq
                                        ).findFirst();
                                if (optionalIq.isPresent() &&
                                        ((Iq) optionalIq.get()).getType().equals("set")) {
                                    ((Iq) optionalIq.get()).setAny(new Session());
                                }
                                break;
                            case "message":
                                tagContent = null;
                                msg = makeMessage(channelId, objects, reader);
                                break;
                            case "presence":
                                Presence presence = new Presence();
                                objects.add(presence);
                                for (int i = 0; i < reader.getAttributeCount(); i++) {
                                    String name = reader.getAttributeLocalName(i);
                                    String val = reader.getAttributeValue(i);
                                    switch (name) {
                                        case "type":
                                            presence.setType(val);
                                            break;
                                    }
                                }
                                break;
                            case "subject":
                                tagContent = null;
                                if (msg != null)
                                    msg.getSubjectOrBodyOrThread().add(new Subject());
                                break;
                            case "body":
                                tagContent = null;
                                if (msg != null)
                                    msg.getSubjectOrBodyOrThread().add(new Body());
                                break;
                            case "thread":
                                tagContent = null;
                                if (msg != null)
                                    msg.getSubjectOrBodyOrThread().add(new ChatThread());
                                break;
                            case "iq":
                                objects.add(makeIQ(reader));
                                break;
                            case "bind":
                                makeBind(objects, reader);
                                break;
                            case "query":
                                makeQuery(objects, reader);
                                break;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        logger.info("END ELEMENT " + reader.getLocalName());
                        if (objects.size() > 0) {
                            switch (reader.getLocalName()) {
                                case "stream":
                                    break;
                                case "resource":
                                    Optional
                                            optionalIq =
                                            objects.stream().filter(
                                                    i -> i instanceof Iq
                                            ).filter(i -> ((Iq) i).getAny() instanceof Bind).findFirst();
                                    if (optionalIq.isPresent() && tagContent != null) {
                                        ((Bind) ((Iq) optionalIq.get()).getAny()).setResource(tagContent);
                                    }
                                    break;
                                case "iq":
                                    logger.info(reader.getLocalName());
                                    break;
                                case "auth":
                                    logger.info(tagContent);
                                    optionalIq =
                                            objects.stream().filter(
                                                    i -> i instanceof Auth
                                            ).findFirst();
                                    if (optionalIq.isPresent() && tagContent != null) {
                                        ((Auth) optionalIq.get()).setValue(tagContent);
                                    }
                                    break;
                                case "subject":
                                    final String subj = tagContent;
                                    msg.getSubjectOrBodyOrThread()
                                            .stream().filter(i -> i instanceof Subject).forEach(
                                            i -> ((Subject) i).setValue(subj)
                                    );
                                    break;
                                case "body":
                                    final String body = tagContent;
                                    msg.getSubjectOrBodyOrThread()
                                            .stream().filter(i -> i instanceof Body).forEach(
                                            i -> ((Body) i).setValue(body)
                                    );
                                    break;
                                case "thread":
                                    final String threadId = tagContent;
                                    msg.getSubjectOrBodyOrThread()
                                            .stream().filter(i -> i instanceof ChatThread).forEach(
                                            i -> ((ChatThread) i).setValue(threadId)
                                    );
                                    break;
                            }
                        }
                        break;

                    case XMLStreamConstants.START_DOCUMENT:
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        break;
                }

            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return objects;
    }

    private static Stream makeStream(XMLStreamReader reader) {
        Stream s = new Stream();
        logger.info("we found CDR!!!");
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeLocalName(i);
            String val = reader.getAttributeValue(i);
            switch (name) {
                case "to":
                    s.setTo(val);
                    break;
                case "version":
                    s.setVersion(val);
                    break;
                case "lang":
                    s.setLang(val);
                    break;
            }
        }
        return s;
    }

    private static Message makeMessage(ChannelId channelId, List<Object> objects, XMLStreamReader reader) {
        Message msg = new Message();
        msg.setChannelId(channelId);
        msg.setTimestamp(System.currentTimeMillis());
        objects.add(msg);
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeLocalName(i);
            String val = reader.getAttributeValue(i);
            switch (name) {
                case "to":
                    msg.setTo(val);
                    break;
                case "id":
                    msg.setId(val);
                    break;
                case "from":
                    msg.setFrom(val);
                    break;
                case "type":
                    msg.setType(val);
                    break;
            }
        }
        return msg;
    }

    private static Iq makeIQ(XMLStreamReader reader) {
        Iq iq = new Iq();
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeLocalName(i);
            String val = reader.getAttributeValue(i);
            switch (name) {
                case "type":
                    iq.setType(val);
                    break;
                case "to":
                    iq.setTo(val);
                    break;
                case "id":
                    iq.setId(val);
                    break;
            }
        }
        return iq;
    }

    private static void makeQuery(List<Object> objects, XMLStreamReader reader) {
        Optional optionalIq;
        optionalIq =
                objects.stream().filter(
                        i -> i instanceof Iq
                ).findFirst();
        if (optionalIq.isPresent()) {
            Query q = new Query();
            q.setNamespace(reader.getNamespaceURI());
            ((Iq) optionalIq.get()).setAny(q);
        }
    }

    private static void makeBind(List<Object> objects, XMLStreamReader reader) {
        Optional optionalIq;
        optionalIq =
                objects.stream().filter(
                        i -> i instanceof Iq
                ).findFirst();
        if (optionalIq.isPresent()) {
            ((Iq) optionalIq.get()).setAny(new Bind());
        }
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeLocalName(i);
            String val = reader.getAttributeValue(i);
            switch (name) {
                case "jid":
                    Bind b = (Bind) ((Iq) optionalIq.get()).getAny();
                    if (val != null)
                        b.setJid(val);
                    break;
            }
        }
        if (objects.get(0) instanceof Stream) {
            objects.remove(0);
        }
    }
}



