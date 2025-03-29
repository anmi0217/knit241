package org.knit.solutions.labor2.lab1.decorator;

class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50; // Добавляем цену сыра
    }

    @Override
    public double getCalories() {
        return super.getCalories() + 2000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", шоколад";
    }
}
