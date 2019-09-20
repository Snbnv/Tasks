package ru.academist.bakanov.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
        head = null;
        count = 0;
    }

    public int getSize() {
        return count;
    }

    public T getHead() {
        return head.getData();
    }

    public T getItem(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным числом");
        }
        if (index > getSize() - 1){
            throw new IllegalArgumentException("Элемента с индексом " + index + " нет в списке");
        }

        int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
            if (i == index) {
                return p.getData();
            }
        }

        return null;
    }

    public T setItem(int index, T data) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным числом");
        }
        if (index > getSize() - 1){
            throw new IllegalArgumentException("Элемента с индексом " + index + " нет в списке");
        }

        int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
            if (i == index) {
                T oldData = p.getData();
                p.setData(data);

                return oldData;
            }
        }

        return null;
    }

    public T removeByIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным числом");
        }
        if (index > getSize() - 1){
            throw new IllegalArgumentException("Элемента с индексом " + index + " нет в списке");
        }

        int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
            if (i == index) {
                ListItem<T> next = p.getNext();
                T removeData = p.getData();

                p.setNext(next.getNext());
                p.setData(next.getData());

                count--;

                return removeData;
            }
        }

        return null;
    }

    public void addHead(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, T data) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным числом");
        }
        if (index > getSize() - 1){
            throw new IllegalArgumentException("Элемента с индексом " + index + " нет в списке");
        }

        int i = 0;

        if (index == 0) {
            addHead(data);
            System.out.println("В начало списка вставлен элемент со сзначением " + data);
        } else {
            for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
                if (p.getNext() == null && i <= index) {
                    ListItem<T> next = new ListItem<>(data, null);
                    p.setNext(next);

                    System.out.println("В конец списка вставлен элемент со сзначением " + data);

                    count++;

                    break;
                }
                if (i == index - 1) {
                    ListItem<T> next = new ListItem<>(data, p.getNext());
                    p.setNext(next);

                    System.out.println("Вставлен элемент c индексом " + index + " и значением " + data);

                    count++;

                    break;
                }
            }
        }
    }

    public boolean removeByData(T data) {
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {
                if (prev != null) {
                    prev.setNext(p.getNext());
                } else {
                    head = head.getNext();
                }

                count--;

                return true;
            }
        }

        return false;
    }

    public T removeHead() {
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
            node.addHead(p.getData());
        }

        node.turn();
        return node;
    }

    public void print() {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }
    }
}
