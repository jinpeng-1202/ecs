package com.jin.reflect;

import java.io.Serializable;

/**
 * @author jinpeng
 * @date 2019/7/16.
 */
public class Baaa extends Aaaa implements Serializable {

    private String nameB;
    private int numB;

    public String pubName;
    public static String staName;

    public Baaa() {
    }

    public Baaa(String p) {
        this.nameB = p;
    }

    static {
        System.out.println("loading Baaa");
    }

    public void hand() {
        System.out.println("hand...");
    }

    public void hand2(String a) {
        System.out.println("hand...=" + a);
    }

    public String hand3(String a, Integer b) {
        System.out.println("hand...=" + a + " num=" + b);
        return a + b;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public int getNumB() {
        return numB;
    }

    public void setNumB(int numB) {
        this.numB = numB;
    }
}
