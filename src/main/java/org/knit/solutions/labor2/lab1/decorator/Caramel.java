package org.knit.solutions.labor2.lab1.decorator;

class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75; // Добавляем цену оливок
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", карамель";
    }

    @Override
    public double getCalories(){
        return super.getCalories() + 1500;
    }
}
