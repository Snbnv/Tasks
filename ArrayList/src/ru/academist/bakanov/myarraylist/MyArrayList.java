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

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            //noinspection unchecked
            items = (E[]) new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Capacity can't be a negative");
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
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] items) {
        if (items.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(this.items, size, items.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(this.items, 0, items, 0, size);
        if (items.length > size) {
            items[size] = null;
        }
        return items;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    System.arraycopy(items, i + 1, items, i, size - i);
                    items[size] = null;
                    ++modCount;
                    --size;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(items[i])) {
                    System.arraycopy(items, i + 1, items, i, size - i);
                    items[size] = null;
                    ++modCount;
                    --size;
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] items = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            if (!contains(items[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] newItems = c.toArray();
        int newSize = newItems.length;
        while (items.length < newSize + size) {
            ensureCapacity(size + newSize);
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(newItems, 0, items, size, newSize);
        size = size + newSize;
        ++modCount;
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> c) {
        if (i < 0) {
            throw new IllegalArgumentException("Index can't be a negative number");
        }
        if (i >= size) {
            throw new NullPointerException("Item with index " + i + " not on the list");
        }

        Object[] newItems = c.toArray();
        int newSize = newItems.length;
        while (items.length < newSize + size) {
            ensureCapacity(size + newSize);
        }

        int numMoved = size - i;
        if (numMoved > 0) {
            System.arraycopy(items, i, items, i + newSize, numMoved);
        } else {
            //noinspection SuspiciousSystemArraycopy
            System.arraycopy(newItems, 0, items, i, newSize);
        }

        size = size + newSize;
        ++modCount;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        final Object[] es = this.items;
        int r;

        for (r = 0; ; r++) {
            if (r == size)
                return false;
            if (c.contains(es[r]))
                break;
        }
        int w = r++;
        try {
            for (Object e; r < size; r++)
                if (!c.contains(e = es[r]))
                    es[w++] = e;
        } catch (Throwable ex) {
            System.arraycopy(es, r, es, w, size - r);
            w += size - r;
            throw ex;
        } finally {
            System.arraycopy(es, size, es, w, 0);
            for (int to = size, i = (size -= size - w); i < to; i++)
                es[i] = null;
        }
        ++modCount;
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        final Object[] es = items;
        int r;

        for (r = 0; ; r++) {
            if (r == size)
                return false;
            if (!c.contains(es[r]))
                break;
        }
        int w = r++;
        try {
            for (Object e; r < size; r++)
                if (c.contains(e = es[r]))
                    es[w++] = e;
        } catch (Throwable ex) {
            System.arraycopy(es, r, es, w, size - r);
            w += size - r;
            throw ex;
        } finally {
            System.arraycopy(es, size, es, w, 0);
            for (int to = size, i = (size -= size - w); i < to; i++) {
                es[i] = null;
            }
            this.size = c.toArray().length;
        }
        ++modCount;
        return true;
    }

    @Override
    public void clear() {
        for (int i = size - 1; i >= 0; i--) {
            items[i] = null;
        }
        size = 0;
        ++modCount;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
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

    @Override
    public E set(int i, E item) {
        if (i < 0) {
            throw new IllegalArgumentException("Index can't be a negative number");
        }
        if (i >= size) {
            throw new NullPointerException("Item with index " + i + " not on the list");
        }
        E oldItem = items[i];
        items[i] = item;
        return oldItem;
    }

    @Override
    public boolean add(E item) {
        ensureCapacity(size);
        items[size] = item;
        ++size;
        ++modCount;
        return true;
    }

    @Override
    public void add(int i, E item) {
        if (i < 0) {
            throw new IllegalArgumentException("Index can't be a negative number");
        }
        if (i >= size) {
            throw new NullPointerException("Item with index " + i + " not on the list");
        }
        ensureCapacity(size);
        System.arraycopy(items, i, items, i + 1, size - i);
        items[i] = item;
        ++size;
        ++modCount;
    }

    @Override
    public E remove(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Index can't be a negative number");
        }
        if (i >= size) {
            throw new NullPointerException("Item with index " + i + " not on the list");
        }
        E oldItem = items[i];
        System.arraycopy(items, i + 1, items, i, size - i - 1);
        --size;
        ++modCount;
        return oldItem;
    }

    private void ensureCapacity(int size) {
        if (size >= items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    public void trimToSize() {
        if (size < items.length) {
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

    public void print() {
        System.out.print("[");
        for (Iterator<E> i = iterator(); i.hasNext(); ) {
            E item = i.next();
            if (!i.hasNext()) {
                System.out.println(item + "]");
                break;
            }
            System.out.print(item + ", ");
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
