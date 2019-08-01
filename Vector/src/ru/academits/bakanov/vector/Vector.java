package ru.academits.bakanov.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] vector;

    public Vector(int n) throws IllegalAccessException {
        if (n <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        this.n = n;
        double[] vector = new double[n];
        this.vector = vector;
        for (int i = 0; i < n; i++) {
            vector[i] = 0;
        }
    }

    public Vector(Vector v) {
        this.n = v.n;
        this.vector = v.vector;
    }

    public Vector(double[] vector) {
        this.n = vector.length;
        this.vector = vector;
    }

    public Vector(int n, double[] v) throws IllegalAccessException {
        if (n <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        if (n < v.length) {
            throw new IllegalAccessException("длина вектора не может быть меньше длины массива ");
        }
        this.n = n;
        double[] vector = new double[n];
        this.vector = vector;

        for (int i = 0; i < n; i++) {
            if (i < v.length) {
                vector[i] = v[i];
            } else {
                vector[i] = 0;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    public int getSize() {
        return this.n;
    }


    public void Summ(Vector v1) {
        int size = (v1.getSize() >= n) ? v1.getSize() : n;
        double[] v = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= n) {
                v[i] = vector[i] + 0;
            }
            if (i > n && i <= v1.getSize()) {
                v[i] = v1.vector[i] + 0;
            }
            if (i < n && i < v1.getSize()) {
                v[i] = vector[i] + v1.vector[i];
            }
        }
        this.n = size;
        this.vector = v;
    }

    public void Different(Vector v1) {
        int size = (v1.getSize() >= n) ? v1.getSize() : n;
        double[] v = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= n) {
                v[i] = vector[i] - 0;
            }
            if (i > n && i <= v1.getSize()) {
                v[i] = v1.vector[i] - 0;
            }
            if (i < n && i < v1.getSize()) {
                v[i] = vector[i] - v1.vector[i];
            }
        }
        this.n = size;
        this.vector = v;
    }

    public void SclProd(double a) {
        for (int i = 0; i < n; i++) {
            vector[i] = vector[i] * a;
        }
    }

    public void Turn() {
        for (int i = 0; i < n; i++) {
            vector[i] = vector[i] * -1;
        }
    }

    public double getModule() {
        double mod = 0;
        for (int i = 0; i < n; i++) {
            mod = mod + vector[i] * vector[i];
        }
        return Math.sqrt(mod);
    }

    public double getComponent(int a) {
        return vector[a];
    }

    public void setComponent(int a, double s) {
        this.vector[a] = s;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(this.vector);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector v = (Vector) o;
        if (this.n != v.n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (this.vector[i] != v.vector[i]) {
                return false;
            }
        }
        return true;
    }

    public static Vector Summ(Vector v1, Vector v2) throws IllegalAccessException {
        int size = (v1.getSize() >= v2.getSize()) ? v1.getSize() : v2.getSize();
        double[] v = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= v2.getSize()) {
                v[i] = v2.vector[i] + 0;
            }
            if (i > v2.getSize() && i <= v1.getSize()) {
                v[i] = v1.vector[i] + 0;
            }
            if (i < v2.getSize() && i < v1.getSize()) {
                v[i] = v1.vector[i] + v2.vector[i];
            }
        }
        return new Vector(size, v);
    }

    public static Vector Different(Vector v1, Vector v2) throws IllegalAccessException {
        int size = (v1.getSize() >= v2.getSize()) ? v1.getSize() : v2.getSize();
        double[] v = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= v2.getSize()) {
                v[i] = v2.vector[i] - 0;
            }
            if (i > v2.getSize() && i <= v1.getSize()) {
                v[i] = v1.vector[i] - 0;
            }
            if (i < v2.getSize() && i < v1.getSize()) {
                v[i] = v1.vector[i] - v2.vector[i];
            }
        }
        return new Vector(size, v);
    }

    public static Vector SclProd(Vector v1, Vector v2) throws IllegalAccessException {
        int size = (v1.getSize() >= v2.getSize()) ? v1.getSize() : v2.getSize();
        double[] v = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= v2.getSize()) {
                v[i] = v2.vector[i] * 0;
            }
            if (i > v2.getSize() && i <= v1.getSize()) {
                v[i] = v1.vector[i] * 0;
            }
            if (i < v2.getSize() && i < v1.getSize()) {
                v[i] = v1.vector[i] * v2.vector[i];
            }
        }
        return new Vector(size, v);
    }
}








