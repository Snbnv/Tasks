package ru.academits.bakanov.shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "квадрат со сторанами: " + sideLength +
                ", полщадью: " + getArea() +
                ", периметром: " + getPerimeter();
    }

    @Override
    public int hashCode() {
        final int prime = 18;
        int hash = 1;
        hash = hash * prime + (int) sideLength;
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
        Circle a = (Circle) o;
        return getWidth() == a.getWidth() && getHeight() == a.getHeight();
    }
}
