package com.learning.concurrentcollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;

class FirstWorker2 implements Runnable {

    private java.util.concurrent.ConcurrentMap<String, Integer> map;

    public FirstWorker2(java.util.concurrent.ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {

        try {
            map.put("B", 1);
            map.put("H", 2);
            Thread.sleep(1000);
            map.put("F", 3);
            map.put("A", 4);
            map.put("E", 5);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SecondWorker2 implements Runnable {

    private java.util.concurrent.ConcurrentMap<String, Integer> map;

    public SecondWorker2(java.util.concurrent.ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {

        try {
            System.out.println(map.get("B"));
            System.out.println(map.get("H"));
            Thread.sleep(2000);
            System.out.println(map.get("E"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConcurrentMap {

    public static void main(String args[]) {

        java.util.concurrent.ConcurrentMap cm = new ConcurrentHashMap();

        new Thread(new FirstWorker2(cm)).start();
        new Thread(new SecondWorker2(cm)).start();

    }
}
