package ru.academist.bakanov.mainarraylist;

import ru.academist.bakanov.myarraylist.MyArrayList;
import java.util.Arrays;

public class MainArrayList {
    public static void main(String[] args) {
        Integer[] items = {1, 2, 3, 5, 4, 6};
        Integer[] sameCollection = {1, 2, 4};
        Integer[] sameCollection2 = {3, 6};
        Integer sameItem = 8;

        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.addAll(Arrays.asList(items));

        System.out.print("Test list ");
        testList.print();
        System.out.println("Size = " + testList.size());
        System.out.println("Test list is empty = " + testList.isEmpty() + "\n");

        System.out.println("Test list contains item " + sameItem + " = " + testList.contains(sameItem) + "\n");

        System.out.println("Collection has been deleted = " + testList.removeAll(Arrays.asList(sameCollection)));
        System.out.print("Test list now ");
        testList.print();
        System.out.println("Size = " + testList.size() + "\n");

        System.out.println("Collection is on the list = " + testList.containsAll(Arrays.asList(sameCollection2)));

    }
}
