package com.jin.threadtest;

/**
 * @author jinpeng
 * @date 2019/5/9.
 */
public  class Dish {

    private String name;
    private boolean vegetarian;
    private int calories;
    private Dish.Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public static enum Type {

        MEAT("1"),
        FISH("2"),
        OTHER("3");

        private String code;

        Type(String code) {
            this.code = code;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
