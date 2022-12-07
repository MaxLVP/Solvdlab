package com.solvd.library.storage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {
    int size;
    MyNode<T> first;
    MyNode<T> last;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<T> current = this.first;
        while (current.next != null) {
            if (current.item == o) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode<T> current = first;
            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                return current.next.item;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        MyNode<T> node;
        if (size == 0) {
            node = new MyNode<>(null, t, null);
            this.first = node;
        } else {
            node = new MyNode<>(this.last, t, null);
            this.last.next = node;
        }
        this.last = node;
        size ++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size == 1) {
            clear();
            return true;
        }
        if (this.first.item == o) {
            MyNode<T> current = this.first;
            this.first = current.next;
            current.next.prev = null;
            return true;
        } else if (this.last.item == o) {
            MyNode<T> current = this.last;
            this.last = current.prev;
            current.prev.next = null;
            return true;
        } else {
            MyNode<T> current = this.first;
            while (current != null) {
                if (current.item == o) {
                    MyNode<T> prev = current.prev;
                    MyNode<T> next = current.next;
                    prev.next = next;
                    next.prev = prev;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.first = null;
        this.size = 0;
        this.last = null;
    }

    @Override
    public T get(int index) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (index == this.size - 1) {
            return this.last.item;
        } else if (index == 0) {
            return this.first.item;
        }
        else {
            int ind = 0;
            MyNode<T> current = this.first;
            while (ind < index) {
                current = current.next;
                ind++;
            }
            return current.item;
        }
    }

    @Override
    public T set(int index, T element) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (index == this.size - 1) {
            this.last.item = element;
        } else if (index == 0) {
            this.first.item = element;
        }
        else {
            int ind = 0;
            MyNode<T> current = this.first;
            while (ind < index) {
                current = current.next;
                ind++;
            }
            current.item = element;
        }
        return element;
    }

    @Override
    public void add(int index, T element) {
        if (index > this.size - 1) {
            throw new IndexOutOfBoundsException();
        } else if (index == this.size) {
            add(element);
            size++;
        } else if (index == 0) {
            MyNode<T> node = new MyNode<>(null, element, this.first);
            this.first.prev = node;
            this.first = node;
            size++;
        }
        else {
            int ind = 0;
            MyNode<T> current = this.first;
            while (ind < index) {
                current = current.next;
                ind++;
            }
            MyNode<T> prev = current.prev;
            MyNode<T> elem = new MyNode<>(prev, element, current);
            current.prev = elem;
            prev.next = elem;
            size++;
        }
    }

    @Override
    public T remove(int index) {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size == 1) {
            clear();
            return null;
        }
        if (index == size - 1) {
            MyNode<T> current = this.last;
            current.prev.next = null;
            this.last = current.prev;
            return current.item;
        } else if (index == 0) {
            MyNode<T> current = this.first;
            current.next.prev = null;
            this.first = current.next;
            return current.item;
        } else {
            int ind = 0;
            MyNode<T> current = this.first;
            while (ind < index) {
                current = current.next;
                ind++;
            }
            MyNode<T> prev = current.prev;
            MyNode<T> next = current.next;
            prev.next = next;
            next.prev = prev;
            return current.item;
        }
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        MyNode<T> current = this.first;
        while (current != null) {
            if (current.item == o) {
                return index;
            }
            current = current.next;
            index ++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        MyNode<T> current = this.last;
        while (current != null) {
            if (current.item == o) {
                return index;
            }
            current = current.prev;
            index --;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Contents: ");
        MyNode<T> current = this.first;
        while( current != null) {
            result.append(current.item);
            result.append(", ");
            current = current.next;
        }
        return result.toString();
    }

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
