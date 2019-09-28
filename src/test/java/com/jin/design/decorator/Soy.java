package com.jin.design.decorator;

/**
 * @author jinpeng
 * @date 2019/9/1.
 */
public class Soy implements Beverage {

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Double cost() {
        return beverage.cost()+6;
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + "+soy";
    }
}
