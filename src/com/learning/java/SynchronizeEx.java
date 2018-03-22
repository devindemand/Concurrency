package com.learning.java;

public class SynchronizeEx {

    private static int count;

    public static void main(String args) {
       // process();
        System.out.println("Finished the process:" + count);
    }


    private static void incrCntr() {

        ++count;
    }

    private static void process() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                incrCntr();
            }


        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                incrCntr();
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
