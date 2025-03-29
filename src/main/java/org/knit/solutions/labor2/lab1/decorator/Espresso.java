package org.knit.solutions.labor2.lab1.decorator;

class Espresso implements Coffee {
    @Override
    public double getCost() {
        return 5.00; // Цена базовой пиццы
    }

    @Override
    public double getCalories() {
        return 1000;
    }

    @Override
    public String getDescription() {
        return "Эспрессо";
    }
}
