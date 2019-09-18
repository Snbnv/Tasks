package ru.academist.bakanov.mainlist;

import ru.academist.bakanov.list.List;
import ru.academist.bakanov.list.ListItem;

public class MainList {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        list.pushHead(5);
        list.pushHead(8);
        list.pushHead(11);
        list.pushHead(2);
        list.pushHead(4);
        list.pushHead(8);

        list.print();
        System.out.println("Начальный элемент списка = " + list.getHead());
        System.out.println("Размер списка  = " + list.getSize());
        System.out.printf("Элемент списка под индексом %d равен %d%n", 3, list.getItem(3));
        list.setItem(2, 22);
        list.remove(4);

        list.print();
        System.out.println("Размер списка  = " + list.getSize());



    }

}
