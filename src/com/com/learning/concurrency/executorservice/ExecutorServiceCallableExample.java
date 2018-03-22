package com.com.learning.concurrency.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Perform N tasks in parallel and report the output as u get it
 */
public class ExecutorServiceCallableExample {
    public static void main(String args[]) {
        List<Future<String>> futureResList = new ArrayList<Future<String>>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Future<String> futureRes = executorService.submit(new CallableEx(i + 1));
            futureResList.add(futureRes);
        }
        for (int i = 0; i < futureResList.size(); i++) {
            try {
                System.out.println(futureResList.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown(); //Important to shutdown
    }
}

class CallableEx implements Callable<String> {
    private int id;

    public CallableEx(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "ID_:" + id;
    }
}