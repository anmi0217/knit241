package org.knit.tasks.task27;

public abstract class CoffeeAdditive implements Coffee {
    protected Coffee coffee;

    public CoffeeAdditive(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost();
    }

    @Override
    public int getVolume() {
        return coffee.getVolume();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
}
