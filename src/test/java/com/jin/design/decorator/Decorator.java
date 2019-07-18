package com.jin.design.decorator;

/**
 * @author jinpeng
 * @date 2019/7/17.
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void biu() {
        this.component.biu();
    }
}
