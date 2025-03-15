package org.knit.solutions.lab2_1.task2_1_2;

class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 40;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n\uD83C\uDF61Добавлена карамель";
    }
}