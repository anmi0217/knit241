package org.knit.Solutions.Task2;

class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", шоколад";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }

    @Override
    public double getCalories() {
        return super.getCalories() + 80;
    }
}
