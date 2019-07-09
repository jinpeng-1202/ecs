package com.jin.design.proxy;

/**
 * @author jinpeng
 * @date 2019/7/1.
 */
public class ProxyObject extends AbstractObject {

    private RealObject realObject;

    public ProxyObject(RealObject realObject) {
        this.realObject = realObject;
    }


    @Override
    public void operation() {
        System.out.println("proxy before do something");
        realObject.operation();
        System.out.println("proxy after do something");
    }
}
