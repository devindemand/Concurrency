package com.learning.librarysimulation;

import java.util.Arrays;
import java.util.Random;

public class Students implements Runnable {

    private int id;
    private Book[] books;

    public Students(int id, Book[] books) {
        this.id = id;
        this.books = books;
    }

    @Override
    public void run() {

        Random random = new Random();
        while (true) {
            int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
            try {
                books[bookId].read(this);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                '}';
    }
}
