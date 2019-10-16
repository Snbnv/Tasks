package ru.academits.bakanov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("длина вектора должна быть больше 0");
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException("длина вектора должна быть больше 0");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("длина вектора должна быть больше 0");
        }

        this.components = Arrays.copyOf(components, n);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (int i = 0; i < components.length; i++) {
            if (i == components.length - 1) {
                s.append(components[i]);
                s.append("}");
                break;
            }
            s.append(components[i]);
            s.append(", ");
        }
        return s.toString();
    }

    public int getSize() {
        return components.length;
    }

    public void sum(Vector vector) {
        int size = Math.max(vector.components.length, components.length);
        if (size > components.length) {
            components = Arrays.copyOf(components, size);
        }
        if (size > vector.components.length) {
            vector.components = Arrays.copyOf(vector.components, size);
        }
        for (int i = 0; i < size; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        int size = Math.max(vector.components.length, components.length);
        if (size > components.length) {
            components = Arrays.copyOf(components, size);
        }
        if (size > vector.components.length) {
            vector.components = Arrays.copyOf(vector.components, size);
        }
        for (int i = 0; i < size; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplicationOnScalar(double a) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= a;
        }
    }

    public void turn() {
        multiplicationOnScalar(-1);
    }

    public double getLength() {
        double length = 0;
        for (double v : components) {
            length += v * v;
        }
        return Math.sqrt(length);
    }

    public double getComponent(int i) {
        return components[i];
    }

    public void setComponent(int i, double component) {
        components[i] = component;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);
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
        if (components.length != vector.components.length) {
            return false;
        }
        for (int i = 0; i < components.length; i++) {
            if (components[i] != vector.components[i]) {
                return false;
            }
        }
        return true;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector v1 = new Vector(vector1.components);
        Vector v2 = new Vector(vector2.components);
        v1.sum(v2);
        return v1;
    }

    public static Vector getDifferent(Vector vector1, Vector vector2) {
        Vector v1 = new Vector(vector1.components);
        Vector v2 = new Vector(vector2.components);
        v1.subtract(v2);
        return v1;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int size = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < size; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }
        return scalarProduct;
    }
}