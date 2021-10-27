package com.company;

import java.util.Arrays;

public class MyQueue<T>{
    private Object[] array;
    private final int INIT_SIZE = 16;
    public MyQueue() {
        array = new Object[INIT_SIZE];
    }
    private int size = 0;
    public MyQueue(int size) {
        array = new Object[size];
    }


    public void add(Object value){
        boolean isFilled = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                isFilled = false;
                break;
            }
        }

        if (isFilled) {
            throw new IllegalArgumentException("queue full");
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
        return (T)array[0];
    }
    public T poll(){
        T temp = peek();
        remove(0);
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
