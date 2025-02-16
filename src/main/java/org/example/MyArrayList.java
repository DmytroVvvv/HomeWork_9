package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyArrayList<T> {
    private Object[] result = new Object[16];
    private int size = 0;

    public void add(T value) {
        result[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        result = new Object[16];
        size = 0;
    }

    public T get(int index) {
        return (T) result[index];
    }

    public void remove(int index) {
        result[index] = null;
        for (int i = index + 1; i < size; i++) {
            result[i - 1] = result[i];
        }
        result[size - 1] = null;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(result[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
