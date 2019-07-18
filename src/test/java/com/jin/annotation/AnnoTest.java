package com.jin.annotation;

/**
 * @author jinpeng
 * @date 2019/7/16.
 */
public class AnnoTest {

    @UserCase
    public void f1() {
    }

    @UserCase(id = 1, desc = "s01")
    public void f2() {
    }
}
