package ru.academist.bakanov.list;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return count;
    }

    public T getHead() {
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }
        return head.getData();
    }

    private void checkIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным числом");
        }
        if (index >= count) {
            throw new IllegalArgumentException("Элемента с индексом " + index + " нет в списке");
        }
    }

    private ListItem<T> iterator(int index) {
        checkIndex(index);

        int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
            if (i == index) {
                return p;
            }
        }

        return null;
    }

    public T getItem(int index) {
        checkIndex(index);

        return Objects.requireNonNull(iterator(index)).getData();
    }

    public T setItem(int index, T data) {
        checkIndex(index);

        ListItem<T> item = iterator(index);

        T oldData = Objects.requireNonNull(item).getData();
        item.setData(data);

        return oldData;
    }

    public T removeByIndex(int index) {
        checkIndex(index);

        ListItem<T> item = iterator(index);

        Objects.requireNonNull(iterator(index - 1)).setNext(Objects.requireNonNull(iterator(index)).getNext());

        count--;

        return Objects.requireNonNull(item).getData();
    }

    public void addHead(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, T data) {
        if (index == 0) {
            addHead(data);
        } else if (index == count) {
            ListItem<T> next = new ListItem<>(data, null);

            Objects.requireNonNull(iterator(index - 1)).setNext(next);

            count++;
        } else {
            checkIndex(index);

            ListItem<T> next = new ListItem<>(data, Objects.requireNonNull(iterator(index - 1)).getNext());

            Objects.requireNonNull(iterator(index - 1)).setNext(next);

            count++;
        }
    }

    public boolean removeByData(T data) {
        boolean remove = false;

        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData() == null) {
                if (prev != null) {
                    prev.setNext(p.getNext());
                } else {
                    head = head.getNext();
                }

                count--;

                remove = true;
            } else if (p.getData().equals(data)) {
                if (prev != null) {
                    prev.setNext(p.getNext());
                } else {
                    head = head.getNext();
                }

                count--;

                remove = true;
            }
        }

        return remove;
    }

    public T removeHead() {
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }

        T oldData = head.getData();
        head = head.getNext();

        count--;

        return oldData;
    }

    public void turn() {
        for (ListItem<T> p = head, prev = null; p != null; ) {
            ListItem<T> next = p.getNext();

            if (next == null) {
                head = p;
            }

            p.setNext(prev);
            prev = p;
            p = next;
        }
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList<T> node = new SinglyLinkedList<>();

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            node.add(node.count, p.getData());
        }

        return node;
    }

    public void print() {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }
    }
}
