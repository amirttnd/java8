package com.demo.thread;

public class Greeting {

    /**
     * welcome method can't be call until currents will not be finish it's execution
     *
     * @param name
     */
    synchronized void welcome(String name) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Hello, " + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
