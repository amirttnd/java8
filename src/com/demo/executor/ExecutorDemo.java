package com.demo.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/***
 * http://tutorials.jenkov.com/java-util-concurrent/executorservice.html
 */
public class ExecutorDemo {

    public static void main(String[] args) throws Exception {
        singleThreadPoolFuture();
    }

    public static void singleThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        executorService.shutdown();
    }

    public static void singleThreadPoolFuture() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(1000);
            return Thread.currentThread().getName();
        });
        System.out.println(future.get());
        executorService.shutdown();
    }


    public static void fixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());

        });
        executorService.submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());

        });
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());

        });
        executorService.submit(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());

        });
        executorService.shutdown();
    }
}

