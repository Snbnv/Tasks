package ru.academist.bakanov.mainarraylist;

import ru.academist.bakanov.myarraylist.MyArrayList;


import java.util.Arrays;

public class MainArrayList {
    public static void main(String[] args) {
        Integer[] items = {1, 2, 3, 5, 4, 6};
        Integer[] sameCollection = {1, 2, 4};
        Integer[] sameCollection2 = {3,6};

        MyArrayList<Integer> arrayList = new MyArrayList<>();

        System.out.println(arrayList.addAll(Arrays.asList(items)));
        arrayList.print();

        System.out.println(arrayList.removeAll(Arrays.asList(sameCollection)));
        arrayList.print();

        System.out.println(arrayList.containsAll(Arrays.asList(sameCollection2)));
        System.out.println(arrayList.size());


    }
}
