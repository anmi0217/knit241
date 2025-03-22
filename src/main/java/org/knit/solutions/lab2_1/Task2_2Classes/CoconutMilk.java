package org.knit.solutions.lab2_1.Task2_2Classes;

public class CoconutMilk extends CoffeeDecorator {
    public CoconutMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.8;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "(+ на кокосовом молоке)";
    }
}
