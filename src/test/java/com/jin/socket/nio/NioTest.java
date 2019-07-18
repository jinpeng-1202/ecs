package com.jin.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author jinpeng
 * @date 2019/5/16.
 */
public class NioTest {

    public static void main(String[] args) throws IOException {

        SocketChannel channel=SocketChannel.open(new InetSocketAddress("localhost",5000));
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        channel.read(buffer);

        WritableByteChannel writableByteChannel= Channels.newChannel(System.out);

        buffer.flip();
        writableByteChannel.write(buffer);
        buffer.clear();

    }

}
