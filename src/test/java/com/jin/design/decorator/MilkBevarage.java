package com.jin.design.decorator;

/**
 * @author jinpeng
 * @date 2019/9/1.
 */
public class MilkBevarage extends Bevarage {

    public MilkBevarage() {
        setMilk(true);
    }

    public Double cost() {
        Double d = 10.00;
        d += super.cost();
        return d;
    }

    public static void main(String[] args) {
        Bevarage milk=new MilkBevarage();
        System.out.println(milk.cost());
    }
}
