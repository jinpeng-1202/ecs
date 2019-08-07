package com.jin.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author jinpeng
 * @date 2019/8/7.
 */
public class ClientDemo1 {

    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 5001));
            if (socketChannel.finishConnect()) {
                String info = "info -------------------------------";
                buffer.clear();
                buffer.put(info.getBytes());
                buffer.flip();
                while (buffer.hasRemaining()) {
                    socketChannel.write(buffer);
                    //System.out.println((char)buffer.get());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socketChannel != null) {
                socketChannel.close();
            }
        }
    }
}
