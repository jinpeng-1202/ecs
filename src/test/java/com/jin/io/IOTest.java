package com.jin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author jinpeng
 * @date 2019/8/19.
 */
public class IOTest {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream=new FileInputStream(new File("\u202AD:\\code\\ecs\\src\\test\\java\\com\\jin\\Test.java"));

    }
}
