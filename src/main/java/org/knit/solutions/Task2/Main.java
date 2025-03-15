package org.labs.Tasks2.Task2;

import org.labs.TasksDescripton;

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

@TasksDescripton(number = 2, name = "Decorator (Декоратор)")
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Espresso();
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new SizeDecorator(coffee, "medium");
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Chocolate(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");
    }
}
