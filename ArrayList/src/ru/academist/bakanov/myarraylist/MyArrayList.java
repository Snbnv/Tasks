package ru.academist.bakanov.myarraylist;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E[] items;
    private int size;
    private int modCount;

    public MyArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[10];
    }

    public MyArrayList(E[] items) {
        this.items = items;
        this.size = items.length;
    }

    public MyArrayList(int capacity) {
        //noinspection unchecked
        items = (E[]) new Object[capacity];
    }

    @Override //rdy
    public int size() {
        return size;
    }

    @Override //rdy
    public boolean isEmpty() {
        return size == 0;
    }

    @Override //not rdy
    public boolean contains(Object o) {
        return false;
    }

    @Override //rdy
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override //not rdy
    public Object[] toArray() {
        return new Object[0];
    }

    @Override //not rdy
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /*@Override
    public boolean add(E e) {
        return false;
    }*/

    @Override //not rdy
    public boolean remove(Object o) {
        return false;
    }

    @Override //not rdy
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override //not rdy
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override //not rdy
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override //not rdy
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override //not rdy
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override //not rdy
    public void clear() {

    }

    /*@Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }*/

    @Override //not rdy
    public int indexOf(Object o) {
        return 0;
    }

    @Override //not rdy
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public E get(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Index can't be a negative number");
        }
        if (i >= size) {
            throw new NullPointerException("Item with index " + i + " not on the list");
        }
        return items[i];
    }

    @Override //not rdy
    public void set(int i, E item) {
        if (i < 0) {
            throw new IllegalArgumentException("Index can't be a negative number");
        }
        if (i >= size) {
            throw new NullPointerException("Item with index " + i + " not on the list");
        }
        for (Iterator<E> iterator = iterator(); iterator.hasNext(); )  {
            if (iterator == items[i]){

            }
        }
    }

    @Override
    public void add(E item) {
        ensureCapacity(size);
        items[size] = item;
        ++size;
        ++modCount;
    }

    @Override //not rdy
    public void add(int i, E item) {
        ensureCapacity(size);

        if (iterator() == items[i]){

        }
        ++size;
        ++modCount;
    }

    @Override // rdy??
    public E remove(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Index can't be a negative number");
        }
        if (i >= size) {
            throw new NullPointerException("Item with index " + i + " not on the list");
        }
        System.arraycopy(items, i + 1, items, i, size - i - 1);
        --size;
        ++modCount;
        return null;
    }

    private void ensureCapacity(int size) {
        if (size >= items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    public void trimToSize(){
        if (!iterator().hasNext()){
            items = Arrays.copyOf(items, size);
        }
    }

    private class MyIterator implements Iterator<E> {
        private int currentIndex = -1;
        private int atMomentCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("It's last item");
            }
            if (atMomentCount != modCount) {
                throw new ConcurrentModificationException("List was changed");
            }
            ++currentIndex;
            return items[currentIndex];
        }
    }

    @Override// rdy
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override// rdy
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override// rdy
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}


