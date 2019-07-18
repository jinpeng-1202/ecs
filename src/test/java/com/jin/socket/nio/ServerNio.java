package com.jin.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author jinpeng
 * @date 2019/7/17.
 */
public class ServerNio {

    public static void main(String[] args) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);//非阻塞
        ssc.socket().bind(new InetSocketAddress(8000));
        ssc.register(selector, SelectionKey.OP_ACCEPT);//注册监听时间
        while (true) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();
                    SocketChannel channel = socketChannel.accept();
                    channel.configureBlocking(false);//接收请求
                    channel.register(selector, SelectionKey.OP_READ);
                    iterator.remove();
                } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    while (true) {
                        buffer.clear();
                        int n = channel.read(buffer);
                        if (n <= 0) {
                            break;
                        }
                        buffer.flip();
                    }
                    iterator.remove();
                }
            }

        }


    }
}
