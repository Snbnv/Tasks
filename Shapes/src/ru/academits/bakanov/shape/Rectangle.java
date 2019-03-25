package ru.academits.bakanov.shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "прямоугольник с шириной: " + width +
                ", высотой: " + height +
                ", полщадью: " + getArea() +
                ", периметром: " + getPerimeter();
    }

    @Override
    public int hashCode() {
        final int prime = 5;
        int hash = 1;
        hash = hash * prime + (int) width;
        hash = hash * prime + Double.hashCode(height);
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
