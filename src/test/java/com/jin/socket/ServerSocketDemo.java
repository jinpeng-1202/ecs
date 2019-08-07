package com.jin.socket;

import com.jin.common.ThreadPoolUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jinpeng
 * @date 2019/5/16.
 */
public class ServerSocketDemo {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            System.out.println("**************");
            Socket socket = serverSocket.accept();

            ThreadPoolUtil.commonPool.execute(() -> {
                try {
                    Writer writer = null;
                    //读取输入
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    char[] chars = new char[102400];
                    reader.read(chars);
                    System.out.println(new String(chars));

                    //返回输出
                    writer = new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()));

                    writer.write("HTTP/1.1 302 FOUND\n" +
                            "Date: Thu, 16 May 2019 08:10:56 GMT\n" +
                            "Content-Type: application/json;charset=UTF-8\n" +
                            "Content-Length: 71\n" +
                            "Server: Redirector\n" +
                            "Location: http://www.baidu.com\n" +
                            "Access-Control-Allow-Origin: *\n" +
                            "Access-Control-Expose-Headers: X-AUTH-TOKEN\n" +
                            "\n" +
                            "{\"code\":\"0000\",\"errorCode\":\"9981\",\"message\":\"授权信息验证出错\"}");
                    writer.flush();
                    writer.close();
                    reader.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
