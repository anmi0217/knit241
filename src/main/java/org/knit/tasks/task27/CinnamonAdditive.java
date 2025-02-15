package org.knit.tasks.task27;

public class CinnamonAdditive extends CoffeeAdditive {
    public CinnamonAdditive(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 25;
    }

    @Override
    public int getVolume() {
        return super.getVolume() + 5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " | с добавлением корицы";
    }
}
