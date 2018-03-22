package com.learning.java.com.learning.java.naming.threads;

import com.learning.java.LoopTaskB;

/**
 * Name a thread from within  a task
 */
public class NamingThreadsFirstWay {

    public static void main(String args[]) {

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "]" + "Main thread starts here....");
        new Thread(new LoopTaskB()).start();

        Thread t2 = new Thread(new LoopTaskB());
        t2.start();
        System.out.println("[" + currentThreadName + "]" + "Main thread ends here....");
    }

}
