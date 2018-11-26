package com.example.ramir.driverapp.util;

public class DoubleArray<T, U> {

    private T first;
    private U second;

    public DoubleArray() {
    }

    public DoubleArray(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public int size() {
        int size = 0;
        if (first != null) size +=1;
        if (second != null) size +=1;
        return size;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}
