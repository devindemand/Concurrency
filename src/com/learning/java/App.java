package com.learning.java;

class Runner1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

public class App {
    public static void main(String args[]) {
        Runner1 r1 = new Runner1();
        Thread t1 = new Thread(r1);
        Runner2 r2 = new Runner2();
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

        System.out.println("Finished completion of the threads in parallel"); //In this example this statement is finished first even before the tasks are fully executed , i.e. the tasks run in t1 and t2 are not even executed and so we that the last print out is executed. How to fix it , look for App2 class where we use join , use join to let the current executing threads to finish
    }


}
