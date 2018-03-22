package com.learning.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingExecutorThreads {

    public static void main(String args[]) {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main threads starts");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        
        System.out.println("[" + currentThreadName + "] Main threads ends");
    }
}
