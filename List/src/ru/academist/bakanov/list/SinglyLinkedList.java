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
        int i = 0;
        //TODO добавить проверку индекса?
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                return p.getData();
            }
            i++;
        }
        //TODO сообщение о неверных данных?
        return null;
    }

    public T setItem(int index, T data) {
        int i = 0;
        //TODO добавить проверку входных данных?
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                T oldData = p.getData();
                p.setData(data);
                return oldData;
            }
            i++;
        }
        //TODO добавить сообщение про не корректные входные данные?
        return null;
    }

    public T removeByIndex(int index) {
        int i = 0;
        //TODO добавить проверку входных данных?
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                ListItem<T> next = p.getNext();
                T removeData = p.getData();
                p.setNext(next.getNext());
                p.setData(next.getData());
                count--;
                return removeData;
            }
            i++;
        }
        //TODO добавить сообщение про не корректные входные данные?
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
            System.out.println("В начало списка вставлен элемент со сзначением " + data);
        } else {
            for (ListItem<T> p = head; p != null; p = p.getNext()) {
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
                    System.out.println("Вставлен элемент под индексом " + index + " со сзначением " + data);
                    count++;
                    break;
                }
                i++;
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
