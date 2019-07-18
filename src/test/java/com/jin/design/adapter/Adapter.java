package com.jin.design.adapter;

/**
 * @author jinpeng
 * @date 2019/7/17.
 * 类适配器 通过继承实现
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        adapteeRequest();
        System.out.println("adapter request");
    }
}
