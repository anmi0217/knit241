package org.knit.solutions.org2.lab2;

class Caramel extends CoffeeDecorator {
    public Caramel(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", карамель";
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 65;
    }
}
