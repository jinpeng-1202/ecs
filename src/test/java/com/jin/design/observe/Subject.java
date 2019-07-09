package com.jin.design.observe;

/**
 * @author jinpeng
 * @date 2019/7/1.
 */
public interface Subject {

    boolean addObserver(Observer observer);

    boolean delObserver(Observer observer);

    void notifyObserver();
}
