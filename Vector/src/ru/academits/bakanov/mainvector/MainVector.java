package ru.academits.bakanov.mainvector;
import ru.academits.bakanov.vector.*;

public class MainVector {
    public static void main (String[] args) throws IllegalAccessException {
        int n = 5;
        double[] vector = new double[]{1, 3.2, 5, 6.1};

        Vector vector1 = new Vector(n);
        System.out.println("Вектор 1 = " + vector1.toString());

        Vector vector2 = new Vector(vector1);
        System.out.println("Вектор 3 = " + vector2.toString());

        Vector vector3 = new Vector(vector);
        System.out.println("Вектор 3 = " + vector3.toString());

        Vector vector4 = new Vector(n, vector);
        System.out.println("Вектор 4 = " + vector4.toString());

        System.out.println("Размерность вектора 3 = " + vector3.getSize());

        vector3.Summ(vector4);
        System.out.println("Вектор 3 после сложение с вектором 4 = " + vector3.toString());

        vector3.Different(vector4);
        System.out.println("Вектор 3 после вычитания вектора 4 = " + vector3.toString());

        vector3.SclProd(5);
        System.out.println("Вектор 3 скалярно умноженный на 5 = " + vector3.toString());

        vector3.Turn();
        System.out.println("Вектор 3 после разворота = " + vector3.toString());

        System.out.println("Длина вектора 3 = " + vector3.getModule());
        System.out.println("3я компонента вектора 4 = " + vector4.getComponent(3));
        vector4.setComponent(3, 7.2);
        System.out.println("3я компонента вектора 4 теперь = " + vector4.getComponent(3));

        System.out.println("Вектор получившийся при сложениии векторов 3 и 4 = " + Vector.Summ(vector3, vector4).toString());
        System.out.println("Вектор получившийся при разности векторов 3 и 4 = " + Vector.Different(vector3, vector4).toString());
        System.out.println("Вектор получившийся при произведении векторов 3 и 4 = " + Vector.SclProd(vector3, vector4).toString());

        System.out.println("Хэшкод вектора 1 = " + vector1.hashCode());
        System.out.println("Хэшкод вектора 2 = " + vector2.hashCode());
        System.out.println("Хэшкод вектора 3 = " + vector3.hashCode());
        System.out.println("Результат сравнение векторов 1 и 3 - " + vector1.equals(vector3));
        System.out.println("Результат сравнение векторов 2 и 1 - " + vector2.equals(vector1));
    }
}
