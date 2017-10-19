package com.demo.executor;


import java.util.concurrent.*;

/**
 * http://tutorials.jenkov.com/java-util-concurrent/executorservice.html
 * http://tutorials.jenkov.com/java-util-concurrent/scheduledexecutorservice.html
 */
public class ExecutorDemo {

    public static void main(String[] args) throws Exception {
        singleThreadPool();
    }

    public static void singleThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        executorService.shutdown();
    }

    public static void scheduledThreadPool() throws Exception{
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }, 1, 1, TimeUnit.SECONDS);
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

