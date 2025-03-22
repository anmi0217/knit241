package org.knit.solutions.org2.lab2;

class Milk extends CoffeeDecorator {
    Milk(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 70;
    }
}
