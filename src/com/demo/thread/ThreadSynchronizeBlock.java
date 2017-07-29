package com.demo.thread;

class Display {
    void number() {
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void character() {
        synchronized (this) {
            for (int i = 65; i <= 90; i++) {
                System.out.println((char) i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class NumberThread extends Thread {
    Display display;

    NumberThread(Display display) {
        this.display = display;
    }

    @Override
    public void run() {
        display.number();
    }
}

class CharacterThread extends Thread {
    Display display;

    CharacterThread(Display display) {
        this.display = display;
    }

    @Override
    public void run() {
        display.character();
    }
}

public class ThreadSynchronizeBlock extends Thread {

    public static void main(String[] args) {
        Display display = new Display();
        NumberThread numberThread = new NumberThread(display);
        CharacterThread characterThread = new CharacterThread(display);
        numberThread.start();
        characterThread.start();
    }
}
