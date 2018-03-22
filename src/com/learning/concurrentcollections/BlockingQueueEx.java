package com.learning.concurrentcollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public FirstWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                counter++;
                blockingQueue.put(counter);
                System.out.println("Adding items to the queue");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class SecondWorker implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public SecondWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                int number = blockingQueue.take();
                Thread.sleep(300);
                System.out.println("Taking items out of the queue:" + number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


public class BlockingQueueEx {
    public static void main(String args[]) {

        BlockingQueue bQueue = new ArrayBlockingQueue(10);
        FirstWorker fw = new FirstWorker(bQueue);
        SecondWorker sw = new SecondWorker(bQueue);

        Thread t1 = new Thread(fw);
        Thread t2 = new Thread(sw);

        t1.start();
        t2.start();
    }
}

