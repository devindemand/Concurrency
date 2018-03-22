package com.learning.dininigphilosopher;

import java.util.Random;

public class Philosopher implements Runnable {

    private int id;
    private ChopStick leftChopStick;
    private ChopStick rightChopStick;
    private Random random;
    private int eatingCounter;
    private volatile boolean isFull;

    public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick) {

        this.id = id;
        this.leftChopStick = leftChopStick;
        this.rightChopStick = rightChopStick;
        this.random = new Random();

    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public void run() {

        try {
            while (!isFull) {

                think();
                if (leftChopStick.pickUp(this, State.LEFT)) {
                    if (rightChopStick.pickUp(this, State.RIGHT)) {
                        eat();
                        rightChopStick.putDown(this, State.RIGHT);
                    }

                    leftChopStick.putDown(this, State.RIGHT);
                }

            }
        } catch (InterruptedException ie) {


        }

    }

    private void think() throws InterruptedException {
        System.out.println(this + " is Thinking");
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(this + " is eating");
        this.eatingCounter++;
        Thread.sleep(random.nextInt(1000));

    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }

    public int getEatingCounter() {
        return eatingCounter;
    }
}