package ru.academits.bakanov.shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return radius * 2;
    }

    public double getHeight() {
        return radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return "круг c радиусом: " + radius +
                ", диаметром: " + getHeight() +
                ", полщадью: " + getArea() +
                ", периметром: " + getPerimeter();
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = hash * prime + (int) radius;
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
