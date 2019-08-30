package ru.academits.bakanov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) throws IllegalAccessException {
        if (n <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        this.components = new double[n];
        for (int i = 0; i < n; i++) {
            this.components[i] = 0;
        }
    }

    public Vector(Vector vector) throws IllegalAccessException {
        if (vector.components.length <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) throws IllegalAccessException {
        if (components.length <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        this.components = components;
    }

    public Vector(int n, double[] components) throws IllegalAccessException {
        if (n <= 0) {
            throw new IllegalAccessException("длина вектора должна быть больше 0");
        }
        this.components = Arrays.copyOf(components, n);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (int i = 0; i < components.length; i++) {
            if (i == components.length - 1) {
                s.append(Math.round(components[i] * 10.0) / 10.0);
                s.append("}");
                break;
            }
            s.append(Math.round(components[i] * 10.0) / 10.0);
            s.append(", ");
        }
        return String.valueOf(s);
    }

    public int getSize() {
        return this.components.length;
    }

    public void sum(Vector vector) {
        if (vector.components.length == this.components.length) {
            for (int i = 0; i < this.components.length; i++) {
                this.components[i] += vector.components[i];
            }
        } else {
            int size = Math.max(vector.components.length, this.components.length);
            if (size > this.components.length) {
                this.components = Arrays.copyOf(this.components, size);
            }
            if (size > vector.components.length) {
                vector.components = Arrays.copyOf(vector.components, size);
            }
            for (int i = 0; i < size; i++) {
                this.components[i] += vector.components[i];
            }
        }
    }

    public void different(Vector vector) {
        if (vector.components.length == this.components.length) {
            for (int i = 0; i < this.components.length; i++) {
                this.components[i] -= vector.components[i];
            }
        } else {
            int size = Math.max(vector.components.length, this.components.length);
            if (size > this.components.length) {
                this.components = Arrays.copyOf(this.components, size);
            }
            if (size > vector.components.length) {
                vector.components = Arrays.copyOf(vector.components, size);
            }
            for (int i = 0; i < size; i++) {
                this.components[i] -= vector.components[i];
            }
        }
    }

    public void scalarProduct(double a) {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] *= a;
        }
    }

    public void turn() {
        scalarProduct(-1);
    }

    public double getLength() {
        double length = 0;
        for (double v : this.components) {
            length = length + v * v;
        }
        return Math.round(Math.sqrt(length) * 10.0) / 10.0;
    }

    public double getComponent(int i) {
        return this.components[i];
    }

    public void setComponent(int i, double value) {
        this.components[i] = value;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(this.components);
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
        Vector vector = (Vector) o;
        if (this.components.length != vector.components.length) {
            return false;
        }
        for (int i = 0; i < this.components.length; i++) {
            if (this.components[i] != vector.components[i]) {
                return false;
            }
        }
        return true;
    }

    public static Vector sum(Vector vector1, Vector vector2) throws IllegalAccessException {
        Vector vector = new Vector(vector1.components);
        vector.sum(vector2);
        return vector;
    }

    public static Vector different(Vector vector1, Vector vector2) throws IllegalAccessException{
        Vector vector = new Vector(vector1.components);
        vector.different(vector2);
        return vector;
    }

    public static double scalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        for (int i = 0; i < vector1.components.length; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }
        return Math.round(scalarProduct * 10.0) / 10.0;
    }
}








