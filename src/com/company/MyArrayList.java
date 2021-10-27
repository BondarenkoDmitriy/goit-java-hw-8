package com.company;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] array;
    private final int INIT_SIZE = 16;
    private int size = 0;

    public MyArrayList() {
        array = new Object[INIT_SIZE];
    }

    public MyArrayList(int size) {
        array = new Object[size];
    }

    public void add(Object value) {
        boolean isFilled = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                isFilled = false;
                break;
            }
        }

        if (isFilled) {
            int oldLength = array.length;
            array = Arrays.copyOf(array, array.length * 2);
            array[oldLength] = value;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = value;
                    break;
                }

            }
            this.size++;
        }
    }

    public void remove(int index) {
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        array = newArray;
        this.size--;
    }

    public void clear() {
        array = new Object[INIT_SIZE];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public Object get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("index must be in collection size range");
        }
        return (Object)array[index];
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                System.out.println();
                break;
            }
            System.out.println(array[i]);
        }
        System.out.println();
    }
}
