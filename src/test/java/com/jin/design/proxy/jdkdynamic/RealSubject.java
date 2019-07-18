package com.jin.design.proxy.jdkdynamic;

/**
 * @author jinpeng
 * @date 2019/7/3.
 */
public class RealSubject implements Subject {

    @Override
    public void dosomething(String a) {
        System.out.println("RealSubject dosomething a=" + a);
        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
