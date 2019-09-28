package com.jin.design.decorator;

/**
 * @author jinpeng
 * @date 2019/9/1.
 */
public class Bevarage {

    private String description;
    private  boolean milk;
    private  boolean soy;
    private  boolean mocha;

    public Double cost(){
        Double d=0.00;
        if(isMilk()){
            d+=5;
        }
        if (isSoy()){
            d+=4;
        }
        if(isMocha()){
            d+=8;
        }
        return d;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }
}
