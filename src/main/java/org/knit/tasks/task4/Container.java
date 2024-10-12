package org.knit.tasks.task4;

public class Container {
    private double availableVolume;

    public Container(double availableVolume) {
        this.availableVolume = availableVolume;
    }

    public void add(Shape shape) {
        double addingVolume = shape.getVolume();
        if (availableVolume >= addingVolume) {
            availableVolume -= addingVolume;
            if (shape instanceof Cube) {
                System.out.printf("В контейнер добавлен куб объемом %.2f\n", addingVolume);
                System.out.printf("Доступный объем контейнера: %.2f\n", availableVolume);
            } else if (shape instanceof Cylinder) {
                System.out.printf("В контейнер добавлен цилиндр объемом %.2f\n", addingVolume);
                System.out.printf("Доступный объем контейнера: %.2f\n", availableVolume);
            } else if (shape instanceof Sphere) {
                System.out.printf("В контейнер добавлен шар объемом %.2f\n", addingVolume);
                System.out.printf("Доступный объем контейнера: %.2f\n", availableVolume);
            } else {
                System.out.printf("В контейнер добавлена фигура объемом %.2f\n", addingVolume);
                System.out.printf("Доступный объем контейнера: %.2f]n", availableVolume);
            }
        } else {
            System.out.printf("Объем добавляемой фигуры: %.2f\n", addingVolume);
            System.out.println("Недостаточно доступного объема контейнера");
        }
    }
}
