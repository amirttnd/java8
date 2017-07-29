package com.demo.thread;

public class ThreadSynchronization extends Thread {

    Greeting greeting;
    String name;

    ThreadSynchronization(Greeting greeting, String name) {
        this.greeting = greeting;
        this.name = name;
    }

    @Override
    public void run() {
        greeting.welcome(name);
    }

    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        ThreadSynchronization t1 = new ThreadSynchronization(greeting, "Name-1");
        ThreadSynchronization t3 = new ThreadSynchronization(greeting, "Name-2");
        ThreadSynchronization t2 = new ThreadSynchronization(greeting, "Name-3");
        t1.start();
        t2.start();
        t3.start();

        //let all threads finish execution before finishing main thread
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End Main Thread");
    }
}
