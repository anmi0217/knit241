package org.knit.tasks.task04;

public class Cube extends Shape {
    private final double edge;

    public Cube(double edge) {
        this.edge = edge;
    }

    @Override
    public double getVolume() {
        return Math.pow(edge, 3);
    }
}
