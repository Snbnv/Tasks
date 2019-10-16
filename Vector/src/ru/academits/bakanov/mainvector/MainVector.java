package ru.academits.bakanov.mainvector;
import ru.academits.bakanov.vector.*;
import static ru.academits.bakanov.vector.Vector.getScalarProduct;

public class MainVector {
    public static void main (String[] args) {
        int n = 5;
        double[] vector = new double[] {1, 3.2, 5, 6.1, 8, 9};
        double[] vector11 = new double[] {14, 5, 3, 12};

        Vector vector1 = new Vector(n);
        System.out.println("Вектор 1 = " + vector1.toString());

        Vector vector2 = new Vector(vector1);
        System.out.println("Вектор 2 = " + vector2.toString());

        Vector vector3 = new Vector(vector);
        System.out.println("Вектор 3 = " + vector3.toString());

        Vector vector4 = new Vector(vector11);
        System.out.println("Вектор 4 = " + vector4.toString());

        Vector vector5 = new Vector(n, vector);
        System.out.println("Вектор 5 = " + vector5.toString());

        System.out.println("Размерность вектора 3 = " + vector3.getSize());

        vector3.sum(vector4);
        System.out.println("Вектор 3 после сложение с вектором 4 = " + vector3.toString());

        vector3.subtract(vector4);
        System.out.println("Вектор 3 после вычитания вектора 4 = " + vector3.toString());

        vector3.multiplicationOnScalar(5);
        System.out.println("Вектор 3 скалярно умноженный на 5 = " + vector3.toString());

        vector3.turn();
        System.out.println("Вектор 3 после разворота = " + vector3.toString());

        System.out.println("Длина вектора 3 = " + vector3.getLength());
        System.out.println("3я компонента вектора 4 = " + vector4.getComponent(3));
        vector4.setComponent(3, 7.2);
        System.out.println("3я компонента вектора 4 теперь = " + vector4.getComponent(3));

        System.out.println("Вектор получившийся при сложениии векторов 3 и 4 = " + Vector.getSum(vector3, vector4).toString());
        System.out.println("Вектор получившийся при разности векторов 3 и 4 = " + Vector.getDifferent(vector3, vector4).toString());
        System.out.println("Произведении векторов 3 и 4 = " + getScalarProduct(vector3, vector4));

        System.out.println("Хэшкод вектора 1 = " + vector1.hashCode());
        System.out.println("Хэшкод вектора 2 = " + vector2.hashCode());
        System.out.println("Хэшкод вектора 3 = " + vector3.hashCode());
        System.out.println("Результат сравнение векторов 1 и 3 - " + vector1.equals(vector3));
        System.out.println("Результат сравнение векторов 2 и 1 - " + vector2.equals(vector1));
    }
}