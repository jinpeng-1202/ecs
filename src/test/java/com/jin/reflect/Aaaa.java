package com.jin.reflect;

/**
 * @author jinpeng
 * @date 2019/7/16.
 */
public class Aaaa {

    private String nameA;

    static{
        System.out.println("loading Aaaa");
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }
}
