package org.example;

public class MyQueue {
    private Object[] result = new Object[10];
    private int size = 0;

    public void clear() {
        result = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        return result[0];
    }

    public Object pool() {
        Object first = result[0];
        for (int i = 1; i < size; i++) {
            result[i - 1] = result[i];
        }
        result[size - 1] = null;
        size--;
        return first;
    }

    public void add(Object value){
        result[size] = value;
        size++;
    }
}
