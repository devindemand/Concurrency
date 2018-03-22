package com.com.learning.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTask {

    public static void main(String args[]) {

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveTask task = new SimpleRecursiveTask(120);
        System.out.println(pool.invoke(task));
    }
}
