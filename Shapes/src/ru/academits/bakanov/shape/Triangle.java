package ru.academits.bakanov.shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }


    @Override
    public double getArea() {
        return Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
    }

    @Override
    public double getPerimeter() {
        double side1 = getSide(x1, y1, x2, y2);
        double side2 = getSide(x2, y2, x3, y3);
        double side3 = getSide(x1, y1, x3, y3);
        return side1 + side2 + side3;
    }

    private static double getSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    @Override
    public String toString() {
        return "треугольник с координатами вершин: (x1 : " + x1 + "; y1 :" + y1 + ") (x2 : " + x2 + "; y2 :" + y2 + ") (x3 : " + x3 + "; y3 : " + y3 + ")" +
                ", с шириной: " + getWidth() +
                ", высотой: " + getHeight() +
                ", полщадью: " + getArea() +
                ", периметром: " + getPerimeter();
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;
        hash = hash * prime + Double.hashCode(x1);
        hash = hash * prime + Double.hashCode(y1);
        hash = hash * prime + Double.hashCode(x2);
        hash = hash * prime + Double.hashCode(y2);
        hash = hash * prime + Double.hashCode(x3);
        hash = hash * prime + Double.hashCode(y3);
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
        Triangle a = (Triangle) o;
        return x1 == a.x1 && y1 == a.y1 && x2 == a.x2 && y2 == a.y2 && x3 == a.x3 && y3 == a.y3;
    }
}