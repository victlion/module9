package org.example;

import java.util.NoSuchElementException;

public class MyQueue<E> {
    private Object[] data;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int front;
    private int rear;
    public MyQueue() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = -1;
    }
    public void add(E value) {
        if (size == data.length) {
            resize();
        }
        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
    }
    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = -1;
    }
    public int size() {
        return size;
    }
    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return data[front];
    }
    public Object poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Object element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return element;
    }
    private void resize() {
        int newCapacity = data.length * 2;
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size - 1;
    }
}
