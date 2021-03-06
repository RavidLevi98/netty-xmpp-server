package com.heim;

import com.heim.netty.SSLHandlerProvider;
import com.heim.netty.SecureChatServerInitializer;
import com.heim.netty.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.io.IOException;


public class NettyServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(boosGroup, workerGroup);
        bootstrap.channel(NioServerSocketChannel.class);

        // ===========================================================
        // 1. define a separate thread pool to execute handlers with
        //    slow business logic. e.g database operation
        // ===========================================================
        final EventExecutorGroup group = new DefaultEventExecutorGroup(1500); //thread pool of 1500

        bootstrap.
                handler(new LoggingHandler(LogLevel.DEBUG)).
                childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline pipeline = ch.pipeline();
                        //pipeline.addLast("idleStateHandler", new IdleStateHandler(0, 0, 60));
                        pipeline.addLast("stringEnc", new StringEncoder());
                        pipeline.addLast("stringDec", new StringDecoder());
                        //     //===========================================================
                        // 2. run handler with slow business logic
                        //    in separate thread from I/O thread
                        //===========================================================
                        //pipeline.addLast(SSLHandlerProvider.getSSLHandler());
                        pipeline.addLast(group, "serverHandler", new ServerHandler());

                        pipeline.addLast(new SecureChatServerInitializer(SSLHandlerProvider.getContext(), group));

                    }
                });

        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.bind(5222).sync();

    }
}