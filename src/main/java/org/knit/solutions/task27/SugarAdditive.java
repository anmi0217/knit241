package org.knit.solutions.task27;

public class SugarAdditive extends CoffeeAdditive {
    public SugarAdditive(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 5;
    }

    @Override
    public int getVolume() {
        return super.getVolume() + 5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " | с добавлением сахара";
    }
}
