package com.learning.java.naming.threads;

import com.learning.java.com.learning.java.naming.threads.ResultListener;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable {

    private int a;
    private int b;
    private int sum;

    private long sleepTime;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private ResultListener<Integer> listener;

    public ValueReturningTaskB(int a, int b, int sleepTime, ResultListener listener) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ValReturnTaskB" + instanceNumber;
        this.listener = listener;
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
        listener.notifyResult(sum);
        System.out.println("### [" + currentThreadName + "] <  + " + taskId + "> DONE ");

    }

}
