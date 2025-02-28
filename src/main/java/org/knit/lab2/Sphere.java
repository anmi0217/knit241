package org.knit.lab2;

public class Sphere extends Shape {
    private double r;

    public Sphere(double radius) {
        this.r = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }

    @Override
    public String toString() {
        return "Радиус сферы = " + r;
    }
}
