package org.knit.solutions.org.lab2;

class Container {
    private double capacity;  // Общий объем контейнера
    private double remainingCapacity;  // Оставшийся объем

    public Container(double capacity) {
        this.capacity = capacity;
        this.remainingCapacity = capacity;
    }

    public void add(Shape shape) {
        double shapeVolume = shape.getVolume();

        if (shapeVolume <= remainingCapacity) {
            remainingCapacity -= shapeVolume;
            System.out.println("Фигура добавлена. Оставшийся объем контейнера: " + remainingCapacity);
        } else {
            System.out.println("Недостаточно места для добавления фигуры. Оставшийся объем контейнера: " + remainingCapacity);
        }
    }

    public double getRemainingCapacity() {
        return remainingCapacity;
    }
}