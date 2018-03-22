package com.learning.java;


import java.util.concurrent.TimeUnit;

public class LoopTaskC implements Runnable {
    private static int count = 0;
    private int id;
    String taskId;

    /**
     * Naming a thread from within the task is not recommended , coz threads life is more than a tasks life and it becomes clumsy during debugging to identify issues with this...
     */


    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("CurrentThreading name:" + currentThreadName + "  Task id sttarting " + id);
        for (int i = 0; i < 10; i++) {

            System.out.println("CurrentThreading name:" + currentThreadName + "  Task id" + id + " :TICK TICK " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("CurrentThreading name:" + currentThreadName + "  Task id ending " + id);
    }

    public LoopTaskC() {

        this.id = ++count;
        this.taskId = "LoopTaskC";

    }
}
