package org.knit.solutions.lab1.task2;

public class Milk extends CoffeeDecorator {
    public Milk(Coffee base) {
        super(base);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.7 * base.getSize();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", с молоком";
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 20 * base.getSize();
    }
}
