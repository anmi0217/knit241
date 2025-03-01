package org.knit.tasks.task27;

public class Cappuccino implements Coffee {
    @Override
    public int getCost() {
        return 250;
    }

    @Override
    public int getVolume() {
        return 300;
    }

    @Override
    public String getDescription() {
        return "Капучино";
    }
}
