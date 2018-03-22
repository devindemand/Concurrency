package com.learning.java.com.learning.java.naming.threads;

import com.learning.java.LoopTaskB;
import com.learning.java.LoopTaskC;

/**
 * Name a thread while creating
 */
public class NamingThreadsSecondWay {

    public static void main(String args[]) {

        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "]" + "Main thread starts here....");
        new Thread(new LoopTaskC(), "MyThread-1").start();

        Thread t2 = new Thread(new LoopTaskC());
        t2.setName("MyThread -2");
        t2.start();
        System.out.println("[" + currentThreadName + "]" + "Main thread ends here....");
    }

}
