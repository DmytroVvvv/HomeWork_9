package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyArrayList {
    private Object[] result = new Object[10];
    private int size = 0;

    public void add(Object value) {
        result[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        result = new Object[10];
        size = 0;
    }

    public Object get(int index) {
        return result[index];
    }
    //1,2,3,4,5
    public void remove(int index){
        result[index] = null;
        for (int i = index + 1; i < size; i++){
            result[i - 1] = result[i];
        }
        result[size - 1] = null;
        size--;
    }

}
