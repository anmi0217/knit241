package org.labs.Tasks2.Task2;

public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5;
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 50;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", молоко";
    }
}