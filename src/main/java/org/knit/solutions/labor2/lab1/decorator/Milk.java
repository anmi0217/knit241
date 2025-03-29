package org.knit.solutions.labor2.lab1.decorator;

class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.00; // Добавляем цену бекона
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }

    @Override
    public double getCalories() {
        return super.getCalories() + 500;
    }
}
