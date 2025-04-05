package org.knit.solutions.TaskSem1;


import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab2.Task4.Container;
import org.knit.solutions.ClassesSem1.lab2.Task4.Cube;
import org.knit.solutions.ClassesSem1.lab2.Task4.Shape;
import org.knit.solutions.ClassesSem1.lab2.Task4.Sphere;

import org.knit.TaskDescription;

/***
 * Задача 4
 * Реализация классов для объемных фигур и контейнера
 *
 * Создайте класс Container, который имеет заданный объем и
 * хранит объемные фигуры, проверяя возможность их добавления.
 *
 * Создайте абстрактный класс Shape с методом getVolume().
 *
 * Реализуйте классы-наследники Shape:
 * - Sphere (сфера) с объемом V = (4/3) * π * r³
 * - Cube (куб) с объемом V = a³
 * - Cylinder (цилиндр) с объемом V = π * r² * h
 *
 * В классе Container реализуйте метод add(Shape shape):
 * - Если фигура помещается в контейнер, добавьте её
 * - Если места недостаточно, выведите сообщение об ошибке
 *
 * Пример использования:
 * Container container = new Container(1000);
 * Shape sphere = new Sphere(5);
 * Shape cube = new Cube(3);
 * container.add(sphere);
 * container.add(cube);
 */
@TaskDescription(taskNumber = 4,
        taskDescription = "Реализация классов для объемных фигур и контейнера",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task4 implements Solution {
    public void execute()  {
        Container container = new Container(1000);  // Создаем контейнер с объемом 1000

        Shape sphere = new Sphere(5);   // Создаем сферу с радиусом 5
        Shape cube = new Cube(3);       // Создаем куб со стороной 3

        container.add(sphere);  // Проверяем, можно ли добавить сферу
        container.add(cube);    // Проверяем, можно ли добавить куб
    }
}


