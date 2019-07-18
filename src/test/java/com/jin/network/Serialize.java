package com.jin.network;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * @author jinpeng
 * @date 2019/7/17.
 */
public class Serialize implements Serializable {

    private String name = "king";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(
                "D:\\my-git\\ecs\\src\\test\\java\\com\\jin\\network\\b.txt"));
        Serialize serialize = new Serialize();
        stream.writeObject(serialize);
        stream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\my-git\\ecs\\src\\test\\java\\com\\jin\\network\\b.txt"));
        Serialize serialize2 = (Serialize) inputStream.readObject();
        System.out.println(JSON.toJSONString(serialize2));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
