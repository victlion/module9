package org.example;

import java.util.Arrays;

public class MyArrayList<T> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] arrayList;
    public MyArrayList(){
        arrayList = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public void add(T value){
        TestCapacity(size+1);
        arrayList[size++] = value;
    }
    public void remove(int index) {
        if(index < 0 || index>arrayList.length){
            throw new IndexOutOfBoundsException();
        }
           for (int i = index; i < size - 1; i++) {
                arrayList[i] = arrayList[i + 1];
            }
            this.size--;
    }
    public void clear(){
        arrayList = new Object[DEFAULT_CAPACITY];
        size=0;
    }
    public int size(){
        return size;
    }
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arrayList[index];
    }
    private void TestCapacity(int index){
        if(index > arrayList.length){
            int newCapacity = arrayList.length * 2;
            Object[] newArray = Arrays.copyOf(arrayList,newCapacity);
            arrayList = newArray;
        }
    }
}
