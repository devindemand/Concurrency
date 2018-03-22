package com.learning.java.com.learning.java.naming.threads;

import com.learning.java.ValueReturningTaskA;

public class ReturningValuesFirstWay {
    /**
     * This is a blcoking way of returning results from a thread / task because we call wait
     *
     * @param args
     */
    public static void main(String args[]) {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ValueReturningTaskA task1 = new ValueReturningTaskA(2, 3, 3000);
        ValueReturningTaskA task2 = new ValueReturningTaskA(3, 4, 1000);
        ValueReturningTaskA task3 = new ValueReturningTaskA(4, 5, 500);

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");
        Thread t3 = new Thread(task3, "Thread-3");
        /**
         * Though one thread finishes before the other , values are printed in the order of the tasks
         */
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Result-1:" + task1.getSum());
        System.out.println("Result-2:" + task2.getSum());
        System.out.println("Result-3:" + task3.getSum());

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
