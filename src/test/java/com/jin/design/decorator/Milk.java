package com.jin.design.decorator;

/**
 * @author jinpeng
 * @date 2019/9/1.
 */
public class Milk implements Beverage {

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Double cost() {
        return beverage.cost() + 5;
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + "+milk";
    }
}
