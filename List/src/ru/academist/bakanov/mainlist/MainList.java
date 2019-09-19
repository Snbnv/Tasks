package ru.academist.bakanov.mainlist;

import ru.academist.bakanov.list.SinglyLinkedList;

public class MainList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addHead(5);
        list.addHead(8);
        list.addHead(11);
        list.addHead(2);
        list.addHead(4);
        list.addHead(8);

        System.out.println("Исходный список ");
        list.print();
        System.out.println("Начальный элемент списка равен " + list.getHead());
        System.out.println("Размер списка  равен " + list.getSize());

        int index = 3;
        System.out.println("Элемент списка под индексом " + index + " равен " + list.getItem(index));

        int index2 = 2;
        Integer data = 22;
        System.out.println("Значение элемента под индексом " + index2 + " изменено с " + list.setItem(index2, data) + " на " + data);

        int index3 = 4;
        System.out.println("Удален элемент под индексом " + index3 + " со значением " + list.removeByIndex(index3));

        list.add(3, 14);

        Integer data2 = 11;
        System.out.println("Удаление элемента со значением " + data2 + " -> " + list.removeByData(data2));

        System.out.println("Удален первый элемент со значением " + list.removeHead());

        System.out.println("Получившийся список");
        list.print();
        System.out.println("Размер списка  = " + list.getSize());

        list.turn();
        System.out.println("Развернутый список");
        list.print();

        SinglyLinkedList node = list.copy();
        System.out.println("Копия списка");
        node.print();
    }

}
