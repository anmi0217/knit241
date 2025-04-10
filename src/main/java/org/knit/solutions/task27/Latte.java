package org.knit.solutions.task27;

public class Latte implements Coffee {
    @Override
    public int getCost() {
        return 275;
    }

    @Override
    public int getVolume() {
        return 350;
    }

    @Override
    public String getDescription() {
        return "Латте";
    }
}
