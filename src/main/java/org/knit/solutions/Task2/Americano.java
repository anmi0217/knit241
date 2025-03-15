package org.labs.Tasks2.Task2;

public class Americano implements Coffee {
    @Override
    public double getCost() {
        return 3.0;
    }

    @Override
    public String getDescription() {
        return "Американо";
    }

    @Override
    public int getCalories() {
        return 10;
    }
}
