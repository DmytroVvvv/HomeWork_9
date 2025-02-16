package org.example;

public class MyStack<T> {
    Object[] result = new Object[16];
    private int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        result = new Object[16];
        size = 0;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }

        result[index] = null;
        for (int i = index + 1; i < size; i++) {
            result[i - 1] = result[i];
        }
        result[size - 1] = null;
        size--;
    }

    public T peek() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        return (T) result[size - 1];
    }


    public T pop() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        T top = (T) result[size - 1];
        result[size - 1] = null;
        size--;
        return top;
    }


    public void push(T value) {
        if (size == result.length) {
            resize();
        }
        result[size] = value;
        size++;
    }


    private void resize() {
        int newCapacity = result.length * 2;
        Object[] newResult = new Object[newCapacity];
        System.arraycopy(result, 0, newResult, 0, result.length);
        result = newResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(result[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

