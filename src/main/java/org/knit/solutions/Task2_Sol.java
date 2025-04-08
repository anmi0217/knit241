package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2.*;

/*
Задача 2.2 Decorator (Декоратор)
Описание:
Декоратор позволяет динамически добавлять новую функциональность объектам без изменения их кода. Это достигается путем обертывания объектов в дополнительные классы.

Пример из жизни:
Рассмотрим кофейню, где клиент может заказывать кофе с различными добавками. Вместо создания отдельных классов для каждого вида кофе, можно использовать декораторы:

Основной кофе
Декораторы: сахар, молоко, карамель и т. д.
Задача:
Реализуйте систему онлайн-заказов кофе.

У вас есть базовый класс Coffee, который имеет метод getCost() и getDescription().
Напишите декораторы для добавления различных ингредиентов (молоко, карамель, шоколад).
Каждый декоратор изменяет стоимость и описание кофе.
Расширьте решение, добавив калорийность и разные виды напитков
 */

@TaskDescription(taskNumber = 2, taskDescription = "Decorator (Декоратор)")
public class Task2_Sol implements Solution{

    public void execute() {
        Coffee coffee = new Espresso();
        System.out.println(coffee);

        // Добавляем размер (medium)
        coffee = new SizeDecorator(coffee, "medium");
        System.out.println(coffee);

        // Добавляем молоко
        coffee = new Milk(coffee);
        System.out.println(coffee);

        // Добавляем карамель
        coffee = new Caramel(coffee);
        System.out.println(coffee);

        // Добавляем шоколад
        coffee = new Chocolate(coffee);
        System.out.println(coffee);
    }
}
