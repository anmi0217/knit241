package org.labs.Tasks2.Task2;

public class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.0;
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 80;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", шоколад";
    }
}
