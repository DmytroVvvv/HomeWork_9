package org.example;

public class MyQueue<T> {
    Object[] result = new Object[16];  // Початковий розмір масиву 16
    private int size = 0;

    public void clear() {
        result = new Object[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) result[0];
    }

    public T pool() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        T first = (T) result[0];
        for (int i = 1; i < size; i++) {
            result[i - 1] = result[i];
        }
        result[size - 1] = null;
        size--;
        return first;
    }

    public void add(T value) {
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
