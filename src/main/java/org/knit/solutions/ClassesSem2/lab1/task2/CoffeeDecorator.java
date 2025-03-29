package org.knit.solutions.ClassesSem2.lab1.task2;

// 3. Абстрактный класс-декоратор (наследуется от Pizza)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee; // Оборачиваемый объект

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public int getCalories() {
        return coffee.getCalories();
    }
    @Override
    public int getSize() {
        return coffee.getSize();
    }
}
