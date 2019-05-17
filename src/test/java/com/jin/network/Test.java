package com.jin.network;

import java.io.*;

/**
 * @author jinpeng
 * @date 2019/5/14.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream(new File("D:\\my-git\\ecs\\src\\test\\java\\com\\jin\\network\\a.txt"));
        outputStream.write("abcefg".getBytes());

        outputStream.flush();
        outputStream.close();

        InputStream inputStream = new FileInputStream(new File("D:\\my-git\\ecs\\src\\test\\java\\com\\jin\\network\\a.txt"));
        byte[] bytes=new byte[20];
        while (true) {
            int i = inputStream.read();
            if (i == -1) {
                break;
            }
            bytes[0] = (byte) i;
            System.out.println(new String(bytes));
        }
        inputStream.close();
    }
}
