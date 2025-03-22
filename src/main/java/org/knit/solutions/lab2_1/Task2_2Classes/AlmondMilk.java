package org.knit.solutions.lab2_1.Task2_2Classes;

// Декоратор миндального молока
public class AlmondMilk extends CoffeeDecorator {
    public AlmondMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "(+ на миндальном молоке)";
    }
}
