package org.knit.solutions.Task2;

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee; // Оборачиваемый объект

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String toString() {
        return this.getDescription() + " | Цена: $" + this.getCost() + " | Калорийность: " + this.getCalories() + " ккал";
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public double getCalories() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
}
