package com.demo.thread;

class Message {
    String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class Reader implements Runnable {
    Message message;

    Reader(Message message) {
        this.message = message;
    }

    String getMessage() {
        synchronized (message) {

            System.out.println(message.getMessage());
            try {
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(message.getMessage());
        }
        return message.getMessage();
    }

    @Override
    public void run() {
        getMessage();
    }
}

class Writer implements Runnable {
    Message message;

    Writer(Message message) {
        this.message = message;

    }

    void write(String msg) {
        message.setMessage(msg);
    }

    @Override
    public void run() {
        synchronized (message) {
            write("Hello, Amir");
            message.notify();
        }
    }
}

public class ThreadWait {

    public static void main(String[] args) {
        Message message = new Message("Default Message");
        Reader reader = new Reader(message);
        Thread rt = new Thread(reader);
        rt.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Writer writer = new Writer(message);
        new Thread(writer).start();
    }
}
