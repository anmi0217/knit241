package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task3.Transport;
import org.knit.solutions.Task3.TransportFactory;

/*
Паттерн Factory используется для создания объектов без указания конкретного класса. Это полезно, когда необходимо создавать объекты на основе входных параметров и логики выбора.

Пример из жизни:
Представьте систему бронирования транспортных средств. В зависимости от типа поездки клиенту предлагается соответствующий вид транспорта: для деловой поездки – бизнес-седан, для семейного отдыха – минивэн, а для экспресс-доставки – мотоцикл.

Задача:
Реализуйте фабрику по созданию различных видов транспортных средств в системе каршеринга.

Создайте интерфейс Transport с методом getSpecifications(), который возвращает характеристики транспортного средства.
Создайте классы BusinessCar, FamilyVan и Motorbike, реализующие Transport.
BusinessCar должен иметь комфортный салон и кожаные сиденья.
FamilyVan должен поддерживать перевозку 6+ пассажиров.
Motorbike предназначен для быстрой доставки.
Создайте класс TransportFactory, который:
Принимает параметр типа поездки ("business", "family", "delivery").
Возвращает соответствующий объект (BusinessCar, FamilyVan, Motorbike).
Добавьте обработку исключений, если передан неизвестный тип транспорта.
Вызов TransportFactory.createTransport("business") должен возвращать объект BusinessCar.
 */

@TaskDescription(taskNumber = 3, taskDescription = "Factory (Фабрика)")
public class Task3Solution implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 3 запущена");

        try {
            Transport transport = TransportFactory.createTransport("business");
            System.out.println(transport.getSpecifications());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}

