package com.demo.datastructure;

/**
 * Created by amir on 11/4/18.
 */
public class Queue<E> {
    Object a[];
    int capacity;
    int front;
    int rear;

    Queue() {
        capacity = 10;
        front = -1;
        rear = -1;
        a = new Object[capacity];

    }

    Queue(int capacity) {
        this.capacity = capacity;
        a = new Object[capacity];
        front = -1;
        rear = -1;
    }

    Object peek() {
        if (front == -1) {
            return null;
        }
        return a[front];
    }

    Object poll() {
        if (front == -1 || front > rear) {
            return null;
        }

        return a[front++];
    }

    boolean offer(E element) {
        if (front == -1) {
            a[++rear] = element;
            front = 0;
            return true;
        } else if (rear <= capacity - 1) {
            a[++rear] = element;
            return true;
        }
        return false;
    }

    int size() {
        if (front == -1) {
            return 0;
        }
        return rear - front + 1;
    }

    void display() {
        for (int i = front; i <= rear; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.display();
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
