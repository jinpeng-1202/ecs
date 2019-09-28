package com.jin.design.observe;

/**
 * @author jinpeng
 * @date 2019/7/1.
 */
public class StudentObserver implements Observer {

    @Override
    public void update(String info) {
        System.out.println("observer:"+info);
    }
}
