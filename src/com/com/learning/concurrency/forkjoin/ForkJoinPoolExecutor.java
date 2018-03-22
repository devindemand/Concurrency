package com.com.learning.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExecutor {

    public static void main(String args[]){

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(1000);
        pool.invoke(simpleRecursiveAction);
    }
}
