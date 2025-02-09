package org.example;

public class MyStack {
    private Object[] result = new Object[10];
    private int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        result = new Object[10];
        size = 0;
    }

    public void remove(int index){
        result[index] = null;
        for (int i = index + 1; i < size; i++){
            result[i - 1] = result[i];
        }
        result[size - 1] = null;
        size--;
    }

    public Object peek(){
        return result[size - 1];
    }

    public Object pop(){
        Object first = result[size - 1];
        result[size - 1] = null;
        size--;
        return first;
    }

    public void push(Object value){
        result[size] = value;
        size++;
    }
}
