package com.jin.design.proxy.jdkdynamic;

/**
 * @author jinpeng
 * @date 2019/7/3.
 */
public class Test<T> {


    public <T> T f1(T t) {
        return t;
    }

    public T f2(T t) {
        return t;
    }

}
