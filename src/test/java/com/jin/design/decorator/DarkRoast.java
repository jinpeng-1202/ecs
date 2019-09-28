package com.jin.design.decorator;

/**
 * @author jinpeng
 * @date 2019/9/1.
 */
public class DarkRoast implements Beverage {

    @Override
    public Double cost() {
        Double d = 20.00;
        return d;
    }

    @Override
    public String getDesc() {
        return "审配咖啡";
    }

    public static void main(String[] args) {
        DarkRoast roast = new DarkRoast();
        Milk milk = new Milk(roast);
        Milk milk2 = new Milk(milk);
        Soy soy = new Soy(milk2);
        System.out.println(soy.cost());
        System.out.println(soy.getDesc());
    }

}
