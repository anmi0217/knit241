package org.knit.solutions.ClassesSem1.lab2.Task4;

public class Container {
    private double remaining_size;

    public Container(double size) {
        this.remaining_size = size;
    }

    public void add(Shape shape) {
        double shape_size = shape.getVolume();

        if (shape_size <= remaining_size) {
            remaining_size -= shape_size;
            System.out.println("Фигура добавлена. Оставшийся объем: " + remaining_size);
        } else {
            System.out.println("Не хватает места для добавления фигуры.");
        }
    }
}
