package com.jin.design.proxy;

/**
 * @author jinpeng
 * @date 2019/7/1.
 */
public class RealObject extends AbstractObject {
    @Override
    public void operation() {
        System.out.println("realObject do something ");
    }
}
