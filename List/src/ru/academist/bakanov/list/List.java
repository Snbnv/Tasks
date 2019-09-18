package ru.academist.bakanov.list;

public class List<T> {
    private ListItem<T> head;
    private int count;

    public List(){
        head = null;
        count = 0;
    }
    public int getSize(){
        return count;
    }

    public Object getHead() {
        return head.getData();
    }

    public Object getItem(int index){
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index){
                return p.getData();
            }
            i++;
        }
        return null;
    }

    public void setItem(int index, T data){
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                T oldData = p.getData();
                p.setData(data);
                System.out.println("Значение элемента под индексом " + index + " изменено с " + oldData + " на " + p.getData());
                break;
            }
            i++;
        }
    }

    public void remove(int index){
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index-1) {
                p = p.getNext();
                count --;
                System.out.println("элемент под индексом " + index + " удален");
                break;
            }
            i++;
        }
    }

    public void pushHead(T data) {
        ListItem<T> p = new ListItem<>(data, head);
        head = p;
        count ++;
    }

    public void print(){
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }
    }
}
