package org.labs.Tasks2.Task2;

public class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.75;
    }

    @Override
    public int getCalories() {
        return coffee.getCalories() + 60;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", карамель";
    }
}
