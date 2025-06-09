package org.knit.solutions.org.lab2;

public class Main {
    public static void main(String[] args) {
        // Создаем контейнер с объемом 1000
        Container container = new Container(1000);

        // Создаем сферу с радиусом 5
        Shape sphere = new Sphere(5);

        // Создаем куб со стороной 3
        Shape cube = new Cube(3);

        // Создаем цилиндр с радиусом 2 и высотой 10
        Shape cylinder = new Cylinder(2, 10);

        // Добавляем фигуры в контейнер
        container.add(sphere);    // Проверка для сферы
        container.add(cube);      // Проверка для куба
        container.add(cylinder);  // Проверка для цилиндра
    }
}
