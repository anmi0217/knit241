package org.knit.solutions.lab2_1.Task2_2Classes;

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

}
