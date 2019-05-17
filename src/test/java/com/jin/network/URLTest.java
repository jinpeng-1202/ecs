package com.jin.network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author jinpeng
 * @date 2019/5/15.
 */
public class URLTest {


    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:5000");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.addRequestProperty("outUserId", "123");
        urlConnection.setRequestMethod("POST");

        System.out.println(urlConnection.getResponseCode());
        System.out.println(urlConnection.getResponseMessage());

        //入参
        Writer writer = new OutputStreamWriter(new BufferedOutputStream(urlConnection.getOutputStream()));
        writer.write("{\"a\":\"0\"}");
        writer.flush();
        writer.close();

        //出参
        Reader reader = new InputStreamReader(new BufferedInputStream(urlConnection.getInputStream()));

        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println(urlConnection.getResponseCode());
        System.out.println(urlConnection.getResponseMessage());

        System.out.println("******************************");
        reader.close();
    }


}
