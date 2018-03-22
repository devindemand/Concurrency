package com.com.learning.concurrency.forkjoin;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction { //the class should extend either Recursive Action or Recursive Task

    private int simulatedWork;

    public SimpleRecursiveAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {   //Every class that extends recursive action or task is added to fork join pool and steps in compiter as executed in parallel

        if (simulatedWork > 100) {
            System.out.println("Parallel execuction and split task..." + simulatedWork);

            //The below tasks would be executed in parallel
            SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(simulatedWork / 20);
            SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(simulatedWork / 20);

            simpleRecursiveAction1.fork();
            simpleRecursiveAction1.fork();

        }else {
            System.out.println("No need of Parallel execuction and sequential processing is ok..." + simulatedWork);

        }
    }
}
