package com.solvd.library.storage;

import java.util.*;

public class MyLinkedList<T> implements List<T> {
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
        MyNode<T> current = first;
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
            MyNode<T> NODE = first;

            @Override
            public boolean hasNext() {
                return NODE != null;
            }

            @Override
            public T next() {
                T item = NODE.item;
                NODE = NODE.next;
                return item;
            }
        };
    }

    @Override
    public Object[] toArray() {
        if (size == 0) {
            throw new NullPointerException();
        }
        Object[] myArray = new Object[size];
        for (int i = 0; i < size; i++) {
            myArray[i] = get(i);
        }
        return myArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (size == 0) {
            throw new NullPointerException();
        }
        if (size <= a.length) {
            for (int i = 0; i < size; i++) {
                a[i] = (T1) get(i);
            }
            return a;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(T t) {
        MyNode<T> node;
        if (size == 0) {
            node = new MyNode<>(null, t, null);
            first = node;
        } else {
            node = new MyNode<>(last, t, null);
            last.next = node;
        }
        last = node;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            clear();
            return true;
        }
        if (first.item == o) {
            MyNode<T> current = first;
            this.first = current.next;
            current.next.prev = null;
            size--;
            return true;
        } else if (last.item == o) {
            MyNode<T> current = last;
            this.last = current.prev;
            current.prev.next = null;
            size--;
            return true;
        } else {
            MyNode<T> current = first;
            while (current != null) {
                if (current.item == o) {
                    MyNode<T> prev = current.prev;
                    MyNode<T> next = current.next;
                    prev.next = next;
                    next.prev = prev;
                    size--;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = true;
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int currentSize = size;
        for (T o : c) {
            add(o);
        }
        return c.size() == size - currentSize;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        int currentSize = size;
        for (T o : c) {
            add(index, o);
            index++;
        }
        return c.size() == size - currentSize;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int currentSize = size;
        for (Object o : c) {
            remove(o);
        }
        return c.size() == currentSize - size;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int currentSize = size;
        MyNode<T> current = first;
        while (current != null) {
            if (!c.contains(current.item)) {
                remove(current.item);
            }
            current = current.next;
        }
        return currentSize != size;
    }

    @Override
    public void clear() {
        this.first = null;
        this.size = 0;
        this.last = null;
    }

    @Override
    public T get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size - 1) {
            return last.item;
        } else if (index == 0) {
            return first.item;
        } else {
            int ind = 0;
            MyNode<T> current = first;
            while (ind < index) {
                current = current.next;
                ind++;
            }
            return current.item;
        }
    }

    @Override
    public T set(int index, T element) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size - 1) {
            last.item = element;
        } else if (index == 0) {
            first.item = element;
        } else {
            int ind = 0;
            MyNode<T> current = first;
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
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            add(element);
        } else if (index == 0) {
            MyNode<T> node = new MyNode<>(null, element, first);
            first.prev = node;
            first = node;
            size++;
        } else {
            int ind = 0;
            MyNode<T> current = first;
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
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            MyNode<T> current = first;
            clear();
            return current.item;
        }
        if (index == size - 1) {
            MyNode<T> current = last;
            current.prev.next = null;
            last = current.prev;
            size--;
            return current.item;
        } else if (index == 0) {
            MyNode<T> current = first;
            current.next.prev = null;
            first = current.next;
            size--;
            return current.item;
        } else {
            int ind = 0;
            MyNode<T> current = first;
            while (ind < index) {
                current = current.next;
                ind++;
            }
            MyNode<T> prev = current.prev;
            MyNode<T> next = current.next;
            prev.next = next;
            next.prev = prev;
            size--;
            return current.item;
        }
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        MyNode<T> current = first;
        while (current != null) {
            if (current.item == o) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        MyNode<T> current = last;
        while (current != null) {
            if (current.item == o) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
            MyNode<T> NODE = first;
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                T item = NODE.item;
                if (NODE.next != null) {
                    NODE = NODE.next;
                }
                index++;
                return item;
            }

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }

            @Override
            public T previous() {
                T item = NODE.item;
                if (NODE.prev != null) {
                    NODE = NODE.prev;
                }
                index--;
                return item;
            }

            @Override
            public int nextIndex() {
                return MyLinkedList.this.indexOf(NODE.next.item);
            }

            @Override
            public int previousIndex() {
                return MyLinkedList.this.indexOf(NODE.prev.item);
            }

            @Override
            public void remove() {
                MyLinkedList.this.remove(NODE.item);
            }

            @Override
            public void set(T t) {
                MyLinkedList.this.set(MyLinkedList.this.indexOf(NODE.item), t);

            }

            @Override
            public void add(T t) {
                MyLinkedList.this.add(MyLinkedList.this.indexOf(NODE.item), t);
            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIterator<T>() {
            MyNode<T> NODE = first;
            private int index1 = index;

            @Override
            public boolean hasNext() {
                return index1 < size;
            }

            @Override
            public T next() {
                T item = NODE.item;
                if (NODE.next != null) {
                    NODE = NODE.next;
                }
                index1++;
                return item;
            }

            @Override
            public boolean hasPrevious() {
                return index1 > 0;
            }

            @Override
            public T previous() {
                T item = NODE.item;
                if (NODE.prev != null) {
                    NODE = NODE.prev;
                }
                index1--;
                return item;
            }

            @Override
            public int nextIndex() {
                return MyLinkedList.this.indexOf(NODE.next.item);
            }

            @Override
            public int previousIndex() {
                return MyLinkedList.this.indexOf(NODE.prev.item);
            }

            @Override
            public void remove() {
                MyLinkedList.this.remove(NODE.item);
            }

            @Override
            public void set(T t) {
                MyLinkedList.this.set(MyLinkedList.this.indexOf(NODE.item), t);

            }

            @Override
            public void add(T t) {
                MyLinkedList.this.add(MyLinkedList.this.indexOf(NODE.item), t);
            }
        };
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (toIndex > size | fromIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        List<T> list = new ArrayList<>();
        MyNode<T> current = first;
        int index = 0;
        while (index != fromIndex) {
            current = current.next;
            index++;
        }
        while (index != toIndex) {
            list.add(current.item);
            current = current.next;
            index++;
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (size == 0) {
            return "[]";
        }
        MyNode<T> current = first;
        while (current != null) {
            result.append(current.item);
            result.append(", ");
            current = current.next;
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(t);
    }

    public T getFirst() {
        return first.item;
    }

    public T getLast() {
        return last.item;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }
}
