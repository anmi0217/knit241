package org.knit.lab2;

public class Cylinder extends Shape {
    private double r;
    private double h;

    public Cylinder(double radius, double height) {
        this.r = radius;
        this.h = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(r, 2) * h;
    }

    @Override
    public String toString() {
        return "Радиус цилиндра = " + r + ", высота = " + h;
    }
}