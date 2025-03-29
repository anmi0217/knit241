package org.knit.solutions.labor2.lab1.decorator;

public class Main {
    public static void main(String[] args) {
        // Создаем кофе
        Coffee coffee = new Espresso();
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калории: " + coffee.getCalories());

        // Добавляем шоколад
        coffee = new Chocolate(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калории: " + coffee.getCalories());

        // Добавляем карамель
        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калории: " + coffee.getCalories());

        // Добавляем молоко
        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калории: " + coffee.getCalories());
    }
}
