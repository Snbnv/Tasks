package ru.academist.bakanov.mainlist;

import ru.academist.bakanov.list.List;

public class MainList {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        list.addHead(5);
        list.addHead(8);
        list.addHead(11);
        list.addHead(2);
        list.addHead(4);
        list.addHead(8);

        list.print();

        System.out.println("Начальный элемент списка равен " + list.getHead());

        System.out.println("Размер списка  = " + list.getSize());

        int index = 3;
        System.out.println("Элемент списка под индексом " + index + " равен " + list.getItem(index));

        int index2 = 2;
        Integer data = 22;
        System.out.println("Значение элемента под индексом " + index2 + " изменено с " + list.setItem(index2, data) + " на " + data);

        int index3 = 4;
        System.out.println("Удален элемент со значением " + list.removeByIndex(index3) + " под индексом " + index3);

        list.add(4, 14);

        Integer data2 = 11;
        System.out.println("Удаление элемента со значением " + data2 + " = " + list.removeByData(data2));

        System.out.println("Удален первый элемент со значением " + list.removeHead());

        list.print();

        System.out.println("Размер списка  = " + list.getSize());

        list.turn();
        System.out.println("Развернутый список");
        list.print();

        List node = list.copy();
        System.out.println("Копия списка");
        node.print();
    }

}
