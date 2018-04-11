package com.demo.datastructure;


import java.util.EmptyStackException;

public class Stack {
    int a[];
    int capacity;
    int length;

    Stack() {
        capacity = 10;
        length = -1;
        a = new int[capacity];
    }

    Stack(int capacity) {
        this.capacity = capacity;
        a = new int[capacity];
    }

    boolean push(int element) {
        if (length == capacity - 1) {
            System.out.println("Stack overflow");
            return false;
        }
        a[++length] = element;
        return true;
    }


    int pop() {
        if (length == -1) {
            throw new EmptyStackException();
        }
        return a[length--];
    }

    int peek() {
        if (length == -1) {
            throw new EmptyStackException();
        }
        return a[length];
    }

    int size() {
        return length + 1;
    }

    void display() {
        for (int i = length; i >= 0; i--) {
            System.out.println("Element:- " + a[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println(stack.size());

        System.out.println(stack.pop());
        stack.display();
        System.out.println(stack.size());

    }
}
