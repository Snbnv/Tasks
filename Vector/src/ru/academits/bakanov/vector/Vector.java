package ru.academits.bakanov.vector;
import java.util.Arrays;

public class Vector{
    private int n;
    private double[] vector ;

    public Vector(int n) throws IllegalAccessException {
        if ( n <=0 ) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        this.n = n;
        double[] vector = new double[n];
        this.vector = vector;
        for (int i = 0; i < n; i++) {
            vector[i] = 0;
        }
    }

    public Vector(Vector v) throws IllegalAccessException {
        this.n = v.n;
        this.vector = v.vector;
    }

    public Vector(double[] vector) {
        this.n = vector.length;
        this.vector = vector;
    }

    public Vector(int n, double[] v) throws IllegalAccessException {
        if ( n <=0 ) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        if ( n < v.length) {
            throw new IllegalAccessException("длина вектора не может быть меньше длины массива ");
        }
        this.n = n;
        double[] vector = new double[n];
        this.vector = vector;

        for (int i = 0; i < n; i++) {
            if (i < v.length){
                vector[i] = v[i];
            } else {
                vector[i] = 0;
            }
        }
    }
    @Override
    public String toString(){
        return Arrays.toString(vector);
    }

    public int getSize(){
        return this.n;
    }


}








