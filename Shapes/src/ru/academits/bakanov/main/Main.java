package ru.academits.bakanov.main;

import ru.academits.bakanov.shape.*;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Square(3);
        Shape shape2 = new Square(8.3);
        Shape shape3 = new Triangle(6.3, 4, 5.5, 6, 1, 3.1);
        Shape shape4 = new Triangle(12, 7, 8, 6, 4.7, 2);
        Shape shape5 = new Rectangle(3, 5);
        Shape shape6 = new Rectangle(4.2, 3.1);
        Shape shape7 = new Circle(1.5);
        Shape shape8 = new Circle(4.5);

        Shape maxAreaShape = getMaxAreaShape(shape1, shape2, shape3, shape4, shape5, shape6, shape7, shape8);
        Shape maxPerimeterShape = getMaxPerimeterShape(shape1, shape2, shape3, shape4, shape5, shape6, shape7, shape8);

        System.out.print("Фигура с наибольшей площадью - ");
        System.out.println(maxAreaShape.toString());

        System.out.print("Фигура со вторым по величине периметром - ");
        System.out.println(maxPerimeterShape.toString());
    }

    private static Shape getMaxAreaShape(Shape... shapes) {
        Arrays.sort(shapes, new AreaComparator());
        return shapes[shapes.length - 1];
    }

    private static Shape getMaxPerimeterShape(Shape... shapes) {
        Arrays.sort(shapes, new PerimeterComparator());
        return shapes[shapes.length - 2];
    }
}

class AreaComparator implements Comparator<Shape> {
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getArea(), b.getArea());
    }
}

class PerimeterComparator implements Comparator<Shape> {
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getPerimeter(), b.getPerimeter());
    }
}