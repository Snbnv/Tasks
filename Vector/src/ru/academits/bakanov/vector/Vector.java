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

    public Vector(Vector v){
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

    /*public void Sum(Vector v1, Vector v2){
        this.n = (v1.getSize() > v2.getSize()) ? v1.getSize() : v2.getSize();
        double[] vector = new double[n];
        this.vector = vector;

        for (int i = 0; i < n; i++) {
            if (i < v1.getSize()){
                vector[i] = v2.vector[i] + 0;
            }
            if (i < v2.getSize()){
                vector[i] = v1.vector[i] + 0;
            }else {
                vector[i] = v1.vector[i] + v2.vector[i];
            }
        }
         new Vector(this.vector);
    }*/

    public void Sum(Vector v1){
        this.n = (v1.getSize() > n) ? v1.getSize() : n;
        double[] v = new double[this.n];
        this.vector = v;

        for (int i = 0; i < this.n; i++) {
            if (i < v1.getSize()){
                v[i] = vector[i] + 0;
            }
            if (i < vector.length){
                v[i] = v1.vector[i] + 0;
            }else {
                v[i] = v1.vector[i] + vector[i];
            }
        }
        new Vector(this.vector);
    }
}








