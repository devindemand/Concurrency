package com.learning.java.com.learning.java.naming.threads;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    List<Integer> list = new ArrayList<Integer>();

    private int LIMIT = 5;
    private int BOTTOM = 0;

    private int value = 0;

    private Object lock = new Object();

    private void produce() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == LIMIT) {
                    System.out.println("Waiting for the removal of elements from the list.... i.e. waiting for the consumer to consume the list");
                    lock.wait();
                } else {
                    System.out.println("Adding values to the list and informing the consumer to consume newly added values to the list");
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }

        }
    }

    private void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == BOTTOM) {
                    System.out.println("Waiting for the adding of elements to the list.... i.e. waiting for the consumer to consume the list");
                    lock.wait();
                } else {
                    System.out.println("Removing values from the list");
                    list.remove(--value);
                    lock.notify();
                }
                Thread.sleep(500);
            }


        }
    }

    public static void main(String args[]) {

        ProducerConsumer pc = new ProducerConsumer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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


    }


}
