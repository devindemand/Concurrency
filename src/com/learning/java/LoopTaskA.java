package com.learning.java;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable {
    private static int count = 0;
    private int id;


    @Override
    public void run() {
        System.out.println("Task id sttarting " + id);
        for (int i = 0; i < 10; i++) {

            System.out.println( "Task id"+ id + " :TICK TICK " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Task id ending " + id);
    }

    public LoopTaskA() {

        this.id = ++count;

    }
}
