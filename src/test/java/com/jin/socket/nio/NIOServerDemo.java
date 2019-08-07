package com.jin.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author jinpeng
 * @date 2019/8/7.
 */
public class NIOServerDemo {

    private static final int BUFFER_SIZE = 1024;
    private static final long TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {
        selector();
    }


    public static void selector() throws IOException {
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(5001));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                if (selector.select(TIMEOUT) == 0) {
                    System.out.println("==");
                    continue;
                }
                //返回selector中就绪的通道
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    Thread.sleep(1 * 1000);
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        handleAccept(key);
                    }
                    if (key.isReadable()) {
                        handleRead(key);
                    }
                    if (key.isWritable() && key.isValid()) {
                        handleWrite(key);
                    }
                    if (key.isConnectable()) {
                        System.out.println("isConnectable = true");
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (selector != null) {
                selector.close();
            }
            if (serverSocketChannel != null) {
                serverSocketChannel.close();
            }
        }
    }

    public static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(BUFFER_SIZE));
    }

    public static void handleRead(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        long read = socketChannel.read(buffer);
        while (read != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            read = socketChannel.read(buffer);
        }
        socketChannel.close();
    }

    public static void handleWrite(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.flip();
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        buffer.compact();
    }
}
