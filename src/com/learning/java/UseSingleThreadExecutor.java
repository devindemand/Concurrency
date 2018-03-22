package com.learning.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseSingleThreadExecutor {

    public static void main(String args[]) {

        System.out.println("Main thread starts");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());

    /*    executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());*/

        executorService.shutdown();// always call this otherwise will cause a memory leak if not shutdown

        //executorService.execute(new LoopTaskA()); // this will throw a Rejected Execution Exception

        System.out.println("Main thread starts");

    }
}
