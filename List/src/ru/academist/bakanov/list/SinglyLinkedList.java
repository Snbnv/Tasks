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

        /*int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
            if (i == index) {
                return p.getData();
            }
        }*/
        return Objects.requireNonNull(iterator(index)).getData();
    }

    public T setItem(int index, T data) {
        checkIndex(index);

        /*int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
            if (i == index) {
                T oldData = p.getData();
                p.setData(data);

                return oldData;
            }
        }*/
        ListItem<T> item = iterator(index);

        T oldData = Objects.requireNonNull(item).getData();
        item.setData(data);

        return oldData;
    }

    public T removeByIndex(int index) {
        checkIndex(index);

        int i = 0;

        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext(), i++) {
            if (i == index) {
                T removeData = p.getData();

                Objects.requireNonNull(prev).setNext(p.getNext());

                p = null;

                count--;
                return removeData;
            }
        }
        /*for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
            if (i == index) {
                ListItem<T> next = p.getNext();
                T removeData = p.getData();

                p.setNext(next.getNext());
                p.setData(next.getData());

                count--;

                return removeData;
            }
        }*/

        return null;
    }

    public void addHead(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, T data) {
        int i = 0;

        if (index == 0) {
            addHead(data);
        }

        else if (index == count) {
            for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
                if (i == index - 1) {
                    ListItem<T> next = new ListItem<>(data, null);
                    p.setNext(next);

                    count++;

                    break;
                }
            }
        }

        else {
            checkIndex(index);
            for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
                if (i == index - 1) {
                    ListItem<T> next = new ListItem<>(data, p.getNext());
                    p.setNext(next);

                    count++;

                    break;
                }
            }
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
            if (p == head) {
                node.addHead(p.getData());
            } else {
                node.add(node.count - 1, p.getData());
            }
        }
        /*ListItem<T> second = node.head.getNext();

        node.head.setNext(second.getNext());
        second.setNext(node.head);
        node.head = second;*/

        return node;
    }

    public void print() {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }
    }
}
