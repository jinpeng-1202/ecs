package com.jin.network;

import java.io.*;

/**
 * @author jinpeng
 * @date 2019/5/14.
 */
public class ReaderWrite {

    public static void main(String[] args) throws IOException {

//        Reader  reader=new InputStreamReader(new FileInputStream(new File("D:\\my-git\\ecs\\src\\test\\java\\com\\jin\\network\\a.txt")));
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(new File("D:\\my-git\\ecs\\src\\test\\java\\com\\jin\\network\\a.txt")));
        char[] chars=new char[1024];
        for (int i = 0; i < 1024; i++) {
            chars[i]='a';
        }

        writer.write(chars);
        System.out.println(writer.getEncoding());

        writer.flush();
        writer.close();

    }
}
