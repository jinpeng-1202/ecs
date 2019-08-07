package com.jin.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author jinpeng
 * @date 2019/5/16.
 */
public class ClientSocketDemo {

    public static void main(String[] args) throws IOException {
        //提示信息
        System.out.println("请输入：");
        //数组缓冲
        byte[] b = new byte[1024];
        while (true) {
            //读取数据
            int n = System.in.read(b);
            //转换为字符串
            String s = new String(b, 0, n);
            socket(s);
        }
    }

    public static void socket(String str) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        Writer writer = new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()));
        writer.write(str);
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true){
            System.out.println(reader.readLine());
        }
        /*char[] chars = new char[102400];
        reader.read(chars);
        System.out.println(new String(chars));
        reader.close();*/

    }
}
