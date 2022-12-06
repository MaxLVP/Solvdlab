package com.solvd.library.storage;

public class MyLinkedList<T> {
    int size;
    MyNode<T> first;
    MyNode<T> last;

    private static class MyNode<T> {
        T item;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(MyNode<T> prev, T element, MyNode<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

    }
}
