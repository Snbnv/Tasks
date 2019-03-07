package ru.academits.bakanov.userange;

import ru.academits.bakanov.range.Range;

class UseRange {
    public static void main(String[] args) {
        Range range = new Range(1, 10);
        double x = 5.2;

        System.out.println("Длинна диапозона = " + range.getLength());

        if (range.isInside(x)) {
            System.out.println("Число лежит в диапозоне");
        } else {
            System.out.println("Число не лежит в диапозоне");
        }
    }
}

