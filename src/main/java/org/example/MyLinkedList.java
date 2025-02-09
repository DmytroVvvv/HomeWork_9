package org.example;

import java.util.Objects;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int size = 0;

    public void add(Object value) {
        if (size == 0) {
            Node current = new Node(value);
            first = current;
            last = current;
        } else {
            Node current = new Node(value);
            current.setPrevious(last);
            last.setNext(current);
            last = current;
        }
        size++;

    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public void remove(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = first.getNext();
        }
        if (current.getPrevious() == null) {
            first = current.getNext();
            current.getNext().setPrevious(null);

        } else if (current.getNext() == null) {
            last = current.getPrevious();
            current.getPrevious().setNext(null);
        } else {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());

        }
            size++;
    }

}

class Node {
    private Object value;
    private Node previous;
    private Node next;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
