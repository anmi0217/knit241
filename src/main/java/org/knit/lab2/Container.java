package org.knit.lab2;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private double maxVolume = 0;
    private double volume = 0;
    private List<Shape> shapes;

    public Container(double maxVolume) {
        this.maxVolume = maxVolume;
        this.volume = maxVolume;
        this.shapes = new ArrayList<>();
    }

    public boolean add(Shape shape) {
        double shapeVolume = shape.getVolume();
        if (shapeVolume <= volume) {
            shapes.add(shape);
            volume -= shapeVolume;
            System.out.println("Фигура " + shape + " добавлена в контейнер. Оставшийся объем: " + volume);
            return true;
        } else {
            System.out.println("Невозможно добавить фигуру " + shape + ": недостаточно места!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Макс. объем контейнера = " + maxVolume + ", оставшийся объем = " + volume;
    }
}
