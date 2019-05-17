package com.jin.threadtest;

/**
 * @author jinpeng
 * @date 2019/5/11.
 */
public class MutablePoint {

    private long x;
    private long y;

    public MutablePoint(){}
    public MutablePoint(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
