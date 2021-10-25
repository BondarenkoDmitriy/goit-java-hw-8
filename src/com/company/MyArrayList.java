package com.company;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] array;

    public MyArrayList() {
        array = new Object[10];
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
        }
    }

    public void remove(int index) {
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        array = newArray;
    }

    public void clear() {
        array = new Object[10];
    }

    public int size() {
        int size = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                break;
            }
            size++;
        }

        return size;
    }

    public T get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("index must be in collection size range");
        }
        return (T)array[index];
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

// MyArrayList list = new MyArrayList(100);
// int[] n = { 1, 2, 3, 4, 5 };
// MyArrayList numbers = new MyArrayList(n);
