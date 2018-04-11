package com.demo.datastructure;

class Node<E> {
    Node<E> link;
    E data;

    Node(E data) {
        this.data = data;
    }

    public Node<E> getLink() {
        return link;
    }

    public void setLink(Node<E> link) {
        this.link = link;
    }

    public Object getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}

public class LinkedList<E> {
    Node<E> start;
    Node<E> end;

    int size = 0;

    void add(E data) {
        Node<E> node = new Node<>(data);
        if (start == null) {
            start = node;
            end = node;
        } else {
            end.setLink(node);
            end = node;
        }
        size++;
    }

    void insertFirst(E data) {
        Node<E> node = new Node<>(data);
        if (start == null) {
            add(data);
        } else {
            node.setLink(start);
            start = node;
        }
    }

    void insertLast(E data) {
        add(data);
    }


    void insertAt(int pos, E data) {
        pos = pos - 1;
        Node<E> head = start;
        Node<E> node = new Node<>(data);
        if (pos <= size) {
            if (pos == 0) {
                insertFirst(data);
            } else if (pos == size) {
                insertLast(data);
            } else {
                for (int i = 0; i < pos; i++) {
                    head = head.getLink();
                }
                node.setLink(head.getLink());
                head.setLink(node);
                size++;
            }
        }
    }

    void display() {
        Node<E> head = start;
        while (head != null) {
            System.out.println(head.getData());
            head = head.getLink();
        }
    }

    int size() {
        return size + 1;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.insertAt(1, 19);
        list.insertFirst(0);
        list.display();
        System.out.println("Size: " + list.size());
    }

}
