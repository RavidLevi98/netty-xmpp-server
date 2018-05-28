//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.28 at 11:27:56 PM MSK 
//


package com.heim.models.xmpp_stanzas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the ietf.params.xml.ns.xmpp_stanzas package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ResourceConstraint_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "resource-constraint");
    private final static QName _RemoteServerTimeout_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "remote-server-timeout");
    private final static QName _NotAuthorized_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "not-authorized");
    private final static QName _NotAllowed_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "not-allowed");
    private final static QName _PaymentRequired_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "payment-required");
    private final static QName _ServiceUnavailable_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "service-unavailable");
    private final static QName _InternalServerError_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "internal-server-error");
    private final static QName _FeatureNotImplemented_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "feature-not-implemented");
    private final static QName _PolicyViolation_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "policy-violation");
    private final static QName _Conflict_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "conflict");
    private final static QName _RegistrationRequired_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "registration-required");
    private final static QName _RecipientUnavailable_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "recipient-unavailable");
    private final static QName _UndefinedCondition_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "undefined-condition");
    private final static QName _BadRequest_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "bad-request");
    private final static QName _RemoteServerNotFound_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "remote-server-not-found");
    private final static QName _NotAcceptable_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "not-acceptable");
    private final static QName _Gone_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "gone");
    private final static QName _Forbidden_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "forbidden");
    private final static QName _SubscriptionRequired_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "subscription-required");
    private final static QName _UnexpectedRequest_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "unexpected-request");
    private final static QName _ItemNotFound_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "item-not-found");
    private final static QName _Redirect_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "redirect");
    private final static QName _JidMalformed_QNAME = new QName("urn:ietf:params:xml:ns:xmpp-stanzas", "jid-malformed");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ietf.params.xml.ns.xmpp_stanzas
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Text }
     */
    public Text createText() {
        return new Text();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "resource-constraint")
    public JAXBElement<String> createResourceConstraint(String value) {
        return new JAXBElement<String>(_ResourceConstraint_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "remote-server-timeout")
    public JAXBElement<String> createRemoteServerTimeout(String value) {
        return new JAXBElement<String>(_RemoteServerTimeout_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "not-authorized")
    public JAXBElement<String> createNotAuthorized(String value) {
        return new JAXBElement<String>(_NotAuthorized_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "not-allowed")
    public JAXBElement<String> createNotAllowed(String value) {
        return new JAXBElement<String>(_NotAllowed_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "payment-required")
    public JAXBElement<String> createPaymentRequired(String value) {
        return new JAXBElement<String>(_PaymentRequired_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "service-unavailable")
    public JAXBElement<String> createServiceUnavailable(String value) {
        return new JAXBElement<String>(_ServiceUnavailable_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "internal-server-error")
    public JAXBElement<String> createInternalServerError(String value) {
        return new JAXBElement<String>(_InternalServerError_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "feature-not-implemented")
    public JAXBElement<String> createFeatureNotImplemented(String value) {
        return new JAXBElement<String>(_FeatureNotImplemented_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "policy-violation")
    public JAXBElement<String> createPolicyViolation(String value) {
        return new JAXBElement<String>(_PolicyViolation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "conflict")
    public JAXBElement<String> createConflict(String value) {
        return new JAXBElement<String>(_Conflict_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "registration-required")
    public JAXBElement<String> createRegistrationRequired(String value) {
        return new JAXBElement<String>(_RegistrationRequired_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "recipient-unavailable")
    public JAXBElement<String> createRecipientUnavailable(String value) {
        return new JAXBElement<String>(_RecipientUnavailable_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "undefined-condition")
    public JAXBElement<String> createUndefinedCondition(String value) {
        return new JAXBElement<String>(_UndefinedCondition_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "bad-request")
    public JAXBElement<String> createBadRequest(String value) {
        return new JAXBElement<String>(_BadRequest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "remote-server-not-found")
    public JAXBElement<String> createRemoteServerNotFound(String value) {
        return new JAXBElement<String>(_RemoteServerNotFound_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "not-acceptable")
    public JAXBElement<String> createNotAcceptable(String value) {
        return new JAXBElement<String>(_NotAcceptable_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "gone")
    public JAXBElement<String> createGone(String value) {
        return new JAXBElement<String>(_Gone_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "forbidden")
    public JAXBElement<String> createForbidden(String value) {
        return new JAXBElement<String>(_Forbidden_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "subscription-required")
    public JAXBElement<String> createSubscriptionRequired(String value) {
        return new JAXBElement<String>(_SubscriptionRequired_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "unexpected-request")
    public JAXBElement<String> createUnexpectedRequest(String value) {
        return new JAXBElement<String>(_UnexpectedRequest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "item-not-found")
    public JAXBElement<String> createItemNotFound(String value) {
        return new JAXBElement<String>(_ItemNotFound_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "redirect")
    public JAXBElement<String> createRedirect(String value) {
        return new JAXBElement<String>(_Redirect_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:xmpp-stanzas", name = "jid-malformed")
    public JAXBElement<String> createJidMalformed(String value) {
        return new JAXBElement<String>(_JidMalformed_QNAME, String.class, null, value);
    }

}
