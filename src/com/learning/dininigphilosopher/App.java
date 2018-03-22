package com.learning.dininigphilosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String args[]) {
        ExecutorService executorService = null;
        Philosopher[] philosophers = null;

        try {

            philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
            ChopStick[] chopSticks = new ChopStick[Constants.NUMBER_OF_CHOPSTICKS];

            for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICKS; i++) {
                chopSticks[i] = new ChopStick(i);
            }

            executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);

            for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICKS; i++) {
                philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i + 1) % Constants.NUMBER_OF_CHOPSTICKS]);
                executorService.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNIGNTIKE);
            for (Philosopher philosopher : philosophers) {
                philosopher.setFull(true);
            }
        } catch (InterruptedException ie) {

        } finally {

            executorService.shutdown();
            while (!executorService.isTerminated()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (Philosopher philosopher : philosophers) {
                System.out.println(philosopher + "eats" + philosopher.getEatingCounter());
            }
        }
    }
}
