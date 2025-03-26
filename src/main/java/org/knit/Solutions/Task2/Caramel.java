package org.knit.Solutions.Task2;

class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75; // Добавляем цену карамели
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", карамель";
    }

    @Override
    public double getCalories(){ return  super.getCalories() + 10.0; }
}
