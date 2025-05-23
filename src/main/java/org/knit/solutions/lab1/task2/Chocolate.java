package org.knit.solutions.lab1.task2;

public class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee base) {
        super(base);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.9 * base.getSize();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", с шоколадом";
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 35 * base.getSize();
    }
}
