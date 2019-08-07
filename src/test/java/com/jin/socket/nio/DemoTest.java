package com.jin.socket.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jinpeng
 * @date 2019/8/6.
 */
public class DemoTest {

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(
                new File("D:\\my-git\\ecs\\src\\test\\java\\com\\jin\\network\\a.txt"));
        FileChannel fileChannel = inputStream.getChannel();
        //创建1024byte容量的的buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //从channel写入数据进buffer
        int read = fileChannel.read(buffer);
        System.out.println(read);
        while (read != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                //从buffer中读取数据
                System.out.print((char) buffer.get());
            }
            buffer.compact();
            read = fileChannel.read(buffer);
            System.out.println(read);
        }
        inputStream.close();
    }


}
