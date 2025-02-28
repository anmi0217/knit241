package org.knit.lab2_1.task2_1_2;

class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 20;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n\uD83C\uDF6BДобавлен шоколад";
    }
}