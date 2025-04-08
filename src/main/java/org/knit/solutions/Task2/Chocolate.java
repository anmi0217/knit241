package org.knit.solutions.Task2;

public class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.00; // Добавляем цену бекона
    }

    public double getCalories() {
        return super.getCost() + 80.00; // Добавляем цену сыра
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", шоколад";
    }
}
