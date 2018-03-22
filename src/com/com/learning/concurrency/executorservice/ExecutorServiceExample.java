package com.com.learning.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * execute() method takes both callable and runnable
 * submit method takes only runnable
 * use callable if u want to return any future value
 * use runnable if u dont want your thread or task to return any thing
 */
public class ExecutorServiceExample {

    public static void main(String args[]) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Worker());
        }
        executorService.shutdown(); //It is important to call the shutdown
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("Exeucting the method");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}