package org.knit.solutions.ClassesSem1.lab2.Task4;

public class Cube extends Shape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public double getVolume() {
        return Math.pow(side, 3);
    }
}
