package org.knit.solutions.TaskSem2;

import org.knit.solutions.ClassesSem2.lab1.task3.*;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 2.3: Factory (Фабрика)
 * <p>
 * Описание:
 * Реализуйте фабрику для создания различных видов транспортных средств в системе каршеринга.
 * Создайте интерфейс Transport с методом getSpecifications(), который возвращает характеристики транспортного средства.
 * Классы BusinessCar, FamilyVan и Motorbike должны реализовать интерфейс Transport и описывать специфические характеристики.
 * Класс TransportFactory должен создавать объект в зависимости от типа поездки ("business", "family", "delivery").
 * Добавьте обработку исключений для неизвестных типов.
 */

@TaskDescription(taskNumber = 3,
        taskDescription = "Factory (Фабрика)",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_3 implements Solution {
    public void execute() {
        try {
            Transport transport1 = TransportFactory.createTransport("business");
            System.out.println(transport1.getSpecifications());

            Transport transport2 = TransportFactory.createTransport("family");
            System.out.println(transport2.getSpecifications());

            Transport transport3 = TransportFactory.createTransport("delivery");
            System.out.println(transport3.getSpecifications());

            Transport transport4 = TransportFactory.createTransport("sd");
            System.out.println(transport4.getSpecifications());

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}


