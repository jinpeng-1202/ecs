package com.jin.design.observe;

import java.util.List;

/**
 * @author jinpeng
 * @date 2019/7/1.
 */
public class TeacherSubject implements Subject {

    private List<Observer> observers;
    private String info;

    @Override
    public boolean addObserver(Observer observer) {
        observers.add(observer);
        return true;
    }

    @Override
    public boolean delObserver(Observer observer) {
        observers.remove(observer);
        return true;
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(info);
        }
    }

    public void setHomework(String info) {
        this.info = info;
    }

}
