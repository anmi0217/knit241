package org.knit.solutions.lab1.task2;

public class Espresso implements Coffee {
    private int volume = 1;

    @Override
    public double getCost() {
        return 4.8 * volume;
    }

    @Override
    public String getDescription() {
        return "Эспрессо (вода, молотый кофе)";
    }

    @Override
    public int getCalories() {
        return 70 * volume;
    }

    @Override
    public int getSize() {
        return volume;
    }

    @Override
    public void setSize(int size) {
        this.volume = size;
    }
}
