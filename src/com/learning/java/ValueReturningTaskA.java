package com.learning.java;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable {

    private int a;
    private int b;
    private int sum;

    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private volatile boolean done; // because this is a shared value between main thread and the other threads calling the task this needs to be volatile

    public ValueReturningTaskA(int a, int b, int sleepTime) {

        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ValReturnTaskA" + instanceNumber;
    }

    @Override
    public void run() {

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("### [" + currentThreadName + "] <  + " + taskId + "> STARTING ");
        System.out.println("### [" + currentThreadName + "] <  + " + taskId + "> SLEEPING For   " + sleepTime + "millis");

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum = a + b;
        System.out.println("### [" + currentThreadName + "] <  + " + taskId + "> DONE ");
        done = true;

        synchronized (this) {
            System.out.println("[" + Thread.currentThread().getName() + "]  " + taskId + "==notifying ... ");
            this.notifyAll(); // so what this does is this thread will notify all the waiting threads when it is done
        }
    }

    public int getSum() {
        if (!done) {
            synchronized (this) {
                try {
                    System.out.println("[" + Thread.currentThread().getName() + "]  ==Waiting for result from " + taskId + "... ");
                    this.wait(); // wait throws a interrupted exeception so use a try catch block
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("[" + Thread.currentThread().getName() + "]  ==Woken up  " + taskId + "... ");
        }
        return sum;
    }
}
