package com.jin.design.proxy.jdkdynamic;

/**
 * @author jinpeng
 * @date 2019/7/3.
 */
public class RealSubject implements Subject {
    @Override
    public void dosomething() {
        System.out.println("RealSubject dosomething");
    }
}
