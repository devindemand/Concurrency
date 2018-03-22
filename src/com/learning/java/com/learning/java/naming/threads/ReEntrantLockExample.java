package com.learning.java.com.learning.java.naming.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample {

    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    public static void increment() {
        lock.lock();

        try {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        } finally { // its a good practice to write unlock in finally otherwise it might cause a dead lock. if there is any exception in the for loop code
            lock.unlock();
        }
    }

    public static void main(String args[]) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The value of the counter is:" + counter);
    }
}
