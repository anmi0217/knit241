package org.knit.solutions.Task2;

public class Espresso implements Coffee {
    @Override
    public String toString() {
        return this.getDescription() + " | Цена: $" + this.getCost() + " | Калорийность: " + this.getCalories() + " ккал";
    }

    @Override
    public double getCost() {
        return 2.5;
    }

    @Override
    public String getDescription() {
        return "Эспрессо";
    }

    @Override
    public double getCalories() {
        return 5.00;
    }
}
