package org.example;

import java.util.EmptyStackException;

public class MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;
    private int top;
    public MyStack() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
        top = -1;
    }
    public void push(E value) {
        if (size == data.length) {
            resize();
        }
        data[++top] = value;
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[top--] = null;
        size--;
    }
    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
        top = -1;
    }
    public int size() {
        return size;
    }
    public Object peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[top];
    }
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object element = data[top];
        data[top--] = null;
        size--;
        return element;
    }
    private void resize() {
        int newCapacity = data.length * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}