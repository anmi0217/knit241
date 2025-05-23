package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;
import org.knit.solutions.lab1.task3.Transport;
import org.knit.solutions.lab1.task3.TransportFactory;

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
    @Override
    public void execute() {
        try {
            Transport t1 = TransportFactory.createTransport("business");
            System.out.println(t1.getSpecifications());

            Transport t2 = TransportFactory.createTransport("family");
            System.out.println(t2.getSpecifications());

            Transport t3 = TransportFactory.createTransport("delivery");
            System.out.println(t3.getSpecifications());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}


