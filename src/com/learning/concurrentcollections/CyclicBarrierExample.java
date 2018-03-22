package com.learning.concurrentcollections;


import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String args[]) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {

            @Override
            public void run() {
                System.out.println("All threads are finished");
            }
        });
        for (int i = 0; i < 5; i++) {

            executorService.submit(new WorkerThread1(i + 1, barrier));
        }
        executorService.shutdown();

    }
}

class WorkerThread1 implements Runnable {
    private int id;
    private CyclicBarrier cyclicBarrier;

    public WorkerThread1(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        doWork();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void doWork() {
        System.out.println("Thread with id:" + this.id + " ... is working");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
