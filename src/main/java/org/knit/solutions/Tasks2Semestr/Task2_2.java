package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;
import org.knit.solutions.lab1.task2.*;

/**
 * Задача 2.2: Decorator (Декоратор)
 * <p>
 * Описание:
 * Реализуйте систему онлайн-заказов кофе с использованием паттерна декоратор.
 * Есть базовый класс Coffee, который имеет метод getCost() и getDescription().
 * Напишите декораторы для добавления ингредиентов (молоко, карамель, шоколад).
 * Каждый декоратор изменяет стоимость и описание кофе, добавьте расчет калорийности.
 */

@TaskDescription(taskNumber = 2,
        taskDescription = "Decorator (Декоратор)",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task2_2 implements Solution {
    public void execute() {
        // Стартовый напиток: эспрессо
        Coffee order = new Espresso();
        System.out.println(order.getDescription() + " | Стоимость: $" + order.getCost() +
                " | Калории: " + order.getCalories() + " ккал");

        // Устанавливаем размер — средний
        order = new SizeDecorator(order, "medium");
        System.out.println(order.getDescription() + " | Стоимость: $" + order.getCost() +
                " | Калории: " + order.getCalories() + " ккал");

        // Добавляем молоко
        order = new Milk(order);
        System.out.println(order.getDescription() + " | Стоимость: $" + order.getCost() +
                " | Калории: " + order.getCalories() + " ккал");

        // Добавляем карамель
        order = new Caramel(order);
        System.out.println(order.getDescription() + " | Стоимость: $" + order.getCost() +
                " | Калории: " + order.getCalories() + " ккал");

        // Завершаем шоколадом
        order = new Chocolate(order);
        System.out.println(order.getDescription() + " | Стоимость: $" + order.getCost() +
                " | Калории: " + order.getCalories() + " ккал");

        // Изменим размер на большой
        order = new SizeDecorator(order, "large");
        System.out.println(order.getDescription() + " | Стоимость: $" + order.getCost() +
                " | Калории: " + order.getCalories() + " ккал");
    }
}
