package com.jin.design.adapter;

/**
 * @author jinpeng
 * @date 2019/7/17.
 */
public class Adapter2 implements Target {

    Adaptee adaptee;

    @Override
    public void request() {
        adaptee.adapteeRequest();
        System.out.println("adapter request");
    }
}
