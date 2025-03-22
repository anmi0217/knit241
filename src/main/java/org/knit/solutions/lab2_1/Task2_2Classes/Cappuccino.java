package org.knit.solutions.lab2_1.Task2_2Classes;

public class Cappuccino implements Coffee {

    @Override
    public double getCost() {
        return 3;
    }

    @Override
    public String getDescription() {
        return "Двойной эспрессо, молоко, пенка";
    }
}
