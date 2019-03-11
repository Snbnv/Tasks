package ru.academits.bakanov.userange;

import ru.academits.bakanov.range.Range;

class UseRange {
    public static void main(String[] args) {
        Range range1 = new Range(1, 15);
        Range range2 = new Range(5, 10);
        Range rangeNew = new Range();
        double x = 5.2;

        System.out.println("Длинна диапозона = " + range1.getLength());

        if (range1.isInside(x)) {
            System.out.printf("Число %.1f лежит в диапозоне (%.1f-%.1f)", x, range1.getFrom(), range1.getTo());
            System.out.println();
        } else {
            System.out.printf("Число %.1f  не лежит в диапозоне (%.1f-%.1f)", x, range1.getFrom(), range1.getTo());
            System.out.println();
        }

        Range rangeIntersection = rangeNew.getIntersection(range1, range2);
        if (rangeIntersection == null) {
            System.out.println("интервалы не пересекаются");
        } else {
            System.out.printf("интервал пересечения (%.1f-%.1f)", rangeIntersection.getFrom(), rangeIntersection.getTo());
            System.out.println();
        }

        Range[] rangeUnion = rangeNew.getUnion(range1, range2);
        if (rangeUnion.length == 1) {
            System.out.printf("интервал объединения (%.1f-%.1f)", rangeUnion[0].getFrom(), rangeUnion[0].getTo());
            System.out.println();
        } else {
            System.out.printf("интервал объединения (%.1f-%.1f, %.1f-%.1f,)", rangeUnion[0].getFrom(), rangeUnion[0].getTo(), rangeUnion[1].getFrom(), rangeUnion[1].getTo());
            System.out.println();
        }

        Range[] rangeDifference = rangeNew.getDifference(range1, range2);
        if (rangeDifference.length == 1) {
            System.out.printf("интервал разности (%.1f-%.1f)", rangeDifference[0].getFrom(), rangeDifference[0].getTo());
            System.out.println();
        } else {
            System.out.printf("интервал разности  (%.1f-%.1f, %.1f-%.1f)", rangeDifference[0].getFrom(), rangeDifference[0].getTo(), rangeDifference[1].getFrom(), rangeDifference[1].getTo());
            System.out.println();
        }
    }
}

