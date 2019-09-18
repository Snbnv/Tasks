package ru.academist.bakanov.list;

public class ListItem<T> {
    private T data;
    private ListItem<T> nextItem;

    public ListItem(T data, ListItem<T> nextItem) {
        this.data = data;
        this.nextItem = nextItem;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListItem<T> getNext() {
        return nextItem;
    }

    public void setNext(ListItem<T> nextItem) {
        this.nextItem = nextItem;
    }
}
