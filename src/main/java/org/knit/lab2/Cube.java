package org.knit.lab2;

public class Cube extends Shape {
    private double a;

    public Cube(double side) {
        this.a = side;
    }

    @Override
    public double getVolume() {
        return Math.pow(a, 3);
    }

    @Override
    public String toString() {
        return "Сторона куба = " + a;
    }
}