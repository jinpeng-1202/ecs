package com.jin.threadtest;

import com.alibaba.fastjson.JSON;
import com.jin.common.ThreadPoolUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jinpeng
 * @date 2019/5/11.
 */
public class MonitorTracker {

    private ConcurrentHashMap<String, MutablePoint> locations;

    public MonitorTracker(ConcurrentHashMap<String, MutablePoint> locations) {
        this.locations = locations;
    }

    public MutablePoint getlocation(String car) {
        return locations.get(car);
    }

    public Map<String, MutablePoint> getlocations() {
        return deepCopy();
    }

    public void setLocations(String car, long x, long y) {
        MutablePoint point = locations.get(car);
        point.setX(x);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        point.setY(y);
    }

    private Map<String, MutablePoint> deepCopy() {
        Map<String, MutablePoint> result = new HashMap<>();
        locations.forEach(result::put);
        return result;
    }

    public static void main(String[] args) {

        ConcurrentHashMap<String, MutablePoint> locations = new ConcurrentHashMap<>();

        for (int i = 0; i < 10; i++) {
            String car = "car" + i;
            MutablePoint point = new MutablePoint(0, 0);
            locations.put(car, point);
        }

        MonitorTracker tracker = new MonitorTracker(locations);

        new Thread(() -> {
            for (; ; ) {
                ThreadPoolUtil.commonPool.execute(() -> {
                    String car = "car" + new Random().nextInt(10);
                    long p = new Random().nextInt(100000);
                    tracker.setLocations(car, p, p);
                });
            }
        }).start();

        for (; ; ) {
            ThreadPoolUtil.queryCorePool.execute(() -> {
                /*String car = "car" + new Random().nextInt(10);
                MutablePoint m = tracker.getlocation(car);
                if (m.getX() == m.getY()) {
                    System.out.println("car=" + car + ":  " + JSON.toJSONString(m));
                }*/

                Map<String, MutablePoint> map = tracker.getlocations();
                map.forEach((s, m) -> {
                    if (m.getX() != m.getY()) {
                        System.out.println("car=" + s + ":  " + JSON.toJSONString(m));
                    }
                });
            });
        }


    }


}
