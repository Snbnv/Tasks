package ru.academits.bakanov.vector;

import java.util.Arrays;

public class Vector {
    private double[] componentsOfVector;

    public Vector(int n) throws IllegalAccessException {
        if (n <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        this.componentsOfVector = new double[n];
        for (int i = 0; i < n; i++) {
            this.componentsOfVector[i] = 0;
        }
    }

    public Vector(Vector v)  throws IllegalAccessException {
        if (v.componentsOfVector.length <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        this.componentsOfVector = Arrays.copyOf(v.componentsOfVector, v.componentsOfVector.length);
    }

    public Vector(double[] vector)  throws IllegalAccessException {
        if (vector.length <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        this.componentsOfVector = vector;
    }

    public Vector(int n, double[] v) throws IllegalAccessException {
        if (n <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }

        this.componentsOfVector = new double[n];

        for (int i = 0; i < n; i++) {
            if (i < v.length) {
                this.componentsOfVector[i] = v[i];
            } else {
                this.componentsOfVector[i] = 0;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (int i = 0; i < componentsOfVector.length; i++){
            if (i == componentsOfVector.length -1) {
                s.append(componentsOfVector[i]);
                s.append("}");
                break;
            }
            s.append(componentsOfVector[i]);
            s.append(", ");
        }
        return String.valueOf(s);
    }

    public int getSize() {
        return this.componentsOfVector.length;
    }


    public void sum(Vector v1) {
        int size = Math.max(v1.getSize(), componentsOfVector.length);
        this.componentsOfVector = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= componentsOfVector.length) {
                componentsOfVector[i] = componentsOfVector[i] + 0;
            }
            if (i > componentsOfVector.length && i <= v1.getSize()) {
                componentsOfVector[i] = v1.componentsOfVector[i] + 0;
            }
            if (i < componentsOfVector.length && i < v1.getSize()) {
                componentsOfVector[i] = componentsOfVector[i] + v1.componentsOfVector[i];
            }
        }
        
    }

    public void different(Vector v1) {
        int size = (v1.getSize() >= componentsOfVector.length) ? v1.getSize() : componentsOfVector.length;
        this.componentsOfVector = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= componentsOfVector.length) {
                componentsOfVector[i] = componentsOfVector[i] - 0;
            }
            if (i > componentsOfVector.length && i <= v1.getSize()) {
                componentsOfVector[i] = v1.componentsOfVector[i] - 0;
            }
            if (i < componentsOfVector.length && i < v1.getSize()) {
                componentsOfVector[i] = componentsOfVector[i] - v1.componentsOfVector[i];
            }
        }
    }

    public void scalarProduct(double a) {
        for (int i = 0; i < componentsOfVector.length; i++) {
            componentsOfVector[i] *= a;
        }
    }

    public void turn() {
        scalarProduct(-1);
    }

    public double getLength() {
        double length = 0;
        for (double v : componentsOfVector) {
            length = length + v * v;
        }
        return Math.sqrt(length);
    }

    public double getComponent(int i) {
        return componentsOfVector[i];
    }

    public void setComponent(int i, double value) {
        this.componentsOfVector[i] = value;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(this.componentsOfVector);
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
        if (this.componentsOfVector.length != v.componentsOfVector.length) {
            return false;
        }
        for (int i = 0; i < this.componentsOfVector.length; i++) {
            if (this.componentsOfVector[i] != v.componentsOfVector[i]) {
                return false;
            }
        }
        return true;
    }

    public static Vector sum(Vector v1, Vector v2) throws IllegalAccessException {
        int size = (v1.getSize() >= v2.getSize()) ? v1.getSize() : v2.getSize();
        double[] v = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= v2.getSize()) {
                v[i] = v2.componentsOfVector[i] + 0;
            }
            if (i > v2.getSize() && i <= v1.getSize()) {
                v[i] = v1.componentsOfVector[i] + 0;
            }
            if (i < v2.getSize() && i < v1.getSize()) {
                v[i] = v1.componentsOfVector[i] + v2.componentsOfVector[i];
            }
        }
        return new Vector(size, v);
    }

    public static Vector different(Vector v1, Vector v2) throws IllegalAccessException {
        int size = (v1.getSize() >= v2.getSize()) ? v1.getSize() : v2.getSize();
        double[] v = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= v2.getSize()) {
                v[i] = v2.componentsOfVector[i] - 0;
            }
            if (i > v2.getSize() && i <= v1.getSize()) {
                v[i] = v1.componentsOfVector[i] - 0;
            }
            if (i < v2.getSize() && i < v1.getSize()) {
                v[i] = v1.componentsOfVector[i] - v2.componentsOfVector[i];
            }
        }
        return new Vector(size, v);
    }

    public static Vector sclProd(Vector v1, Vector v2) throws IllegalAccessException {
        int size = (v1.getSize() >= v2.getSize()) ? v1.getSize() : v2.getSize();
        double[] v = new double[size];

        for (int i = 0; i < size; i++) {
            if (i > v1.getSize() && i <= v2.getSize()) {
                v[i] = v2.componentsOfVector[i] * 0;
            }
            if (i > v2.getSize() && i <= v1.getSize()) {
                v[i] = v1.componentsOfVector[i] * 0;
            }
            if (i < v2.getSize() && i < v1.getSize()) {
                v[i] = v1.componentsOfVector[i] * v2.componentsOfVector[i];
            }
        }
        return new Vector(size, v);
    }
}








