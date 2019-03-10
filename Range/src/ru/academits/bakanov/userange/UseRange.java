package ru.academits.bakanov.userange;
import ru.academits.bakanov.range.Range;
import java.util.Arrays;

class UseRange {
    public static void main(String[] args) {
        Range range = new Range(1, 10);
        Range range2 = new Range(5, 15);
        Range rangeNew = new Range();
        double x = 5.2;

        System.out.println("Длинна диапозона = " + range.getLength());

        if (range.isInside(x)) {
            System.out.printf("Число %.1f лежит в диапозоне (%.1f-%.1f)", x, range.getFrom(), range.getTo());
            System.out.println();
        } else {
            System.out.printf("Число %.1f  не лежит в диапозоне (%.1f-%.1f)", x, range.getFrom(), range.getTo());
            System.out.println();
        }

        Range rangeIntersection = rangeNew.getIntersection(range, range2);
        if (rangeIntersection == null) {
            System.out.println("интервалы не пересекаются");
        } else {
            System.out.printf("интервал пересечения - (%.1f-%.1f)", rangeIntersection.getFrom(), rangeIntersection.getTo());
            System.out.println();
        }

        Range[] rangeUnion = rangeNew.getUnion(range, range2);
        System.out.println("интервал объединения  (" + Arrays.toString(rangeUnion) + ")");

        rangeNew.getDifference(range, range2);
    }
}

