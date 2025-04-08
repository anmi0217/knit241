package org.knit.solutions.Task2;

public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; // Добавляем цену сыра
    }

    public double getCalories() {
        return super.getCost() + 50.00; // Добавляем цену сыра
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }
}
