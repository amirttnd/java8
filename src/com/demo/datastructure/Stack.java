package com.demo.datastructure;


import java.util.EmptyStackException;

public class Stack<T> {
    Object []a;
    int capacity;
    int length;

    Stack() {
        capacity = 10;
        length = -1;
        a = new Object[capacity];
    }

    Stack(int capacity) {
        this.capacity = capacity;
        a = new Object[capacity];
    }

    boolean push(T element) {
        if (length == capacity - 1) {
            System.out.println("Stack overflow");
            return false;
        }
        a[++length] = element;
        return true;
    }


    Object pop() {
        if (length == -1) {
            throw new EmptyStackException();
        }
        return a[length--];
    }

    T peek() {
        if (length == -1) {
            throw new EmptyStackException();
        }
        return (T)a[length];
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
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        stack.size();

        Stack<String> stack1=new Stack<>();
        stack1.push("a");
        stack1.push("b");
        stack1.push("c");
        stack1.display();

    }
}
