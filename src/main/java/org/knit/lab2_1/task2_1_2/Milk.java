package org.knit.lab2_1.task2_1_2;

class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 20;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n\uD83E\uDD5BДобавлено молоко";
    }
}