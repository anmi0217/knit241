package org2.lab2;

class Marshmallow extends CoffeeDecorator {
    public Marshmallow(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.3;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", маршмеллоу";
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 5;
    }
}
