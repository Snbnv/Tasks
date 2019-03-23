package ru.academits.bakanov.main;

import ru.academits.bakanov.shape.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Square(3);
        Shape shape2 = new Square(8.3);
        Shape shape3 = new Triangle(6.3, 4, 5.5, 6, 1, 3.1);
        Shape shape4 = new Triangle(12, 7, 8, 6, 4.7, 2);
        Shape shape5 = new Rectangle(3 ,5);
        Shape shape6 = new Rectangle(4.2 ,3.1);
        Shape shape7 = new Circle(4.5);
        Shape shape8 = new Circle(6);

    }

    public static Shape getMaxAreaShape(Shape... numbers){
        double [] shapesArea = {}
        return Arrays.sort()
    }
}
