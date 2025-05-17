package org.knit.solutions.org2.lab2;

class Espresso implements Coffee {

    @Override
    public double getCost() {
        return 2.5;
    }

    @Override
    public String getDescription() {
        return "Эспрессо";
    }

    @Override
    public int getCalories() {
        return 5;
    }
}
