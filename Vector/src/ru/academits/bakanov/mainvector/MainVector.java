package ru.academits.bakanov.mainvector;
import ru.academits.bakanov.vector.*;

public class MainVector {
    public static void main (String[] args) throws IllegalAccessException {
        int n = 5;
        double[] vector = new double[]{1, 3.2, 5, 6.1};

        Vector vector1 = new Vector(n);
        System.out.println(vector1.toString());

        Vector vector2 = new Vector(vector1);
        System.out.println(vector2.toString());

        Vector vector3 = new Vector(vector);
        System.out.println(vector3.toString());

        Vector vector4 = new Vector(n, vector);
        System.out.println(vector4.toString());

        System.out.println(vector3.getSize());


    }
}
