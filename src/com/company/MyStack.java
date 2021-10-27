package com.company;

import java.util.Arrays;

public class MyStack<T> {
    private Object[] array;
    private int size = 0;
    private final int INIT_SIZE = 16;
    public MyStack() {
        array = new Object[INIT_SIZE];
    }

    public MyStack(int size) {
        array = new Object[size];
    }

    public void push(Object value){
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
        }size++;
    }
    public void remove(int index) {
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        array = newArray;
        size--;
    }

    public void clear() {
        array = new Object[INIT_SIZE];
    }

    public int size() {
//        int size = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == null) {
//                break;
//            }
//            size++;
//        }

        return size;
    }

    public T peek(){
        return (T)array[size-1];
    }
    public T pop(){
            T temp = peek();
            remove(size-1);
            return temp;
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
