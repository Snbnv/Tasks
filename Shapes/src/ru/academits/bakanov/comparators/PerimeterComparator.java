package ru.academits.bakanov.comparators;

import ru.academits.bakanov.shape.Shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getPerimeter(), b.getPerimeter());
    }
}
