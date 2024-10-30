package org.knit.tasks.task04;

public class Task4 {
    public static void main(String[] args) {
        Container container = new Container(100);
        container.add(new Cube(3));
        container.add(new Cylinder(2, 4));
        container.add(new Sphere(5));
    }
}
