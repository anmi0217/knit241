package org.knit.tasks.task27;

public class MilkAdditive extends CoffeeAdditive {
    public MilkAdditive(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 10;
    }

    @Override
    public int getVolume() {
        return super.getVolume() + 15;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " | с добавлением молока";
    }
}
