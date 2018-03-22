package com.com.learning.concurrency.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {

    private int simulatedWork;

    public SimpleRecursiveTask(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected Integer compute() {
        if (simulatedWork > 100) {
            System.out.println("Parallel execution needed because of the size which is:" + simulatedWork);
            SimpleRecursiveTask t1 = new SimpleRecursiveTask(simulatedWork / 2);
            SimpleRecursiveTask t2 = new SimpleRecursiveTask(simulatedWork / 2);

            t1.fork();
            t2.fork();

            int solution = 0;
            solution += t1.join();
            solution += t2.join();

            return solution;
        } else {
            System.out.println("No need for parallel execution");
            return 2 * simulatedWork;
        }
    }
}
