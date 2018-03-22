package com.learning.java;


class Runner11 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

class Runner21 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

public class App2 {
    public static void main(String args[]) {
        Runner11 r1 = new Runner11();
        Thread t1 = new Thread(r1);
        Runner21 r2 = new Runner21();
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join(); // when we use join the current executing thread is allowed to run and the main thread is paused until these threads are finished with the tasks
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // join needs to be encapsulated in try catch blocks because it throws a interrupted exception
        System.out.println("Finished completion of the threads in parallel"); //In this example this statement is finished first even before the tasks are fully executed , i.e. the tasks run in t1 and t2 are not even executed and so we that the last print out is executed. How to fix it , look for App2 class where we use join , use join to let the current executing threads to finish
    }


}
