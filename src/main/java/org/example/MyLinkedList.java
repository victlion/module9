package org.example;


public class MyLinkedList<E> {
    private Node<E> start;
    private Node<E> end;
    private int size;
    private static class Node<E>{
        E data;
        Node<E> next;
        Node<E> prev;
        Node(E data) {
            this.data = data;
        }
    }
    public MyLinkedList() {
        start = null;
        end = null;
        size = 0;
    }
    public void add(E value){
        Node<E> newNode = new Node<>(value);
        if(size==0){
            start = newNode;
        }else{
            end.next = newNode;
            newNode.prev = end;
        }
        end = newNode;
        size++;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> searchNode = start;
        for (int i = 0; i < index; i++) {
            searchNode = searchNode.next;
        }
        return searchNode.data;
    }
    public int size() {
        return size;
    }
    public void clear() {
        while (start != null) {
            Node<E> next = start.next;
            start.data = null;
            start.next = null;
            start.prev = null;
            start = next;
        }
        end = null;
        size = 0;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> nodeToRemove = start;
        for (int i = 0; i < index; i++) {
            nodeToRemove = nodeToRemove.next;
        }
        if (nodeToRemove.prev == null) {
            start = nodeToRemove.next;
        } else {
            nodeToRemove.prev.next = nodeToRemove.next;
        }
        if (nodeToRemove.next == null) {
            end = nodeToRemove.prev;
        } else {
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        nodeToRemove.data = null;
        nodeToRemove.next = null;
        nodeToRemove.prev = null;
        size--;
    }
}
