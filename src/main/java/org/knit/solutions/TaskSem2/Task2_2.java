package org.knit.solutions.TaskSem2;

import org.knit.solutions.ClassesSem2.lab1.task2.*;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

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
        // Базовый кофе
        Coffee coffee = new Espresso();
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() +
                " | Калорийность: " + coffee.getCalories() + " ккал");

        // Добавляем размер (medium)
        coffee = new SizeDecorator(coffee, "medium");
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() +
                " | Калорийность: " + coffee.getCalories() + " ккал");

        // Добавляем молоко
        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() +
                " | Калорийность: " + coffee.getCalories() + " ккал");

        // Добавляем карамель
        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() +
                " | Калорийность: " + coffee.getCalories() + " ккал");

        // Добавляем шоколад
        coffee = new Chocolate(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() +
                " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new SizeDecorator(coffee, "large");
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() +
                " | Калорийность: " + coffee.getCalories() + " ккал");
    }
}

