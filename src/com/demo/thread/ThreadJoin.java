package com.demo.thread;

public class ThreadJoin extends Thread {
    long mills = 1000;

    public ThreadJoin() {

    }

    public ThreadJoin(long mills) {
        this.mills = mills;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(mills);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Until Thread t1 will not complete
     * Main Thread will not execute
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread.currentThread().setName("Main Thread :-");

        ThreadJoin td1 = new ThreadJoin(100);

        Thread t1 = new Thread(td1, "Child Thread :-");
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
