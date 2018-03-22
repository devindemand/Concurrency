package com.com.learning.concurrency.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphores have 2 important methods acquire and release() , when called if a permit is available lock is given to the thread
 * release -- if called a permit is added , this prevent starvation
 * Semaphores maintain the number of permits and not the thread accessing the resource
 * <p>
 * Here in this example though we have instantiated 12 threads to run in parallel only 5 threads download the data at any given point in time this is because we've used the semaphore to restrict the downloads to 5 threads
 * after these 5 threads are done with the execution the next 5 threads of the left over 7 are given a lock until then they are in the waiting state
 */
enum Download {

    INSTANCE;

    private Semaphore semaphore = new Semaphore(5, true);

    public void downloadData() {
        try {
            semaphore.acquire();
            download();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // this prevents starvation
        }
    }

    private void download() {
        System.out.println("Downloading data from the web");
    }

}

public class SemaphoreExample {

    public static void main(String args[]) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 12; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Download.INSTANCE.downloadData();
                }
            });
        }

    }
}
