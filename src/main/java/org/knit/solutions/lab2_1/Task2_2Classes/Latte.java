package org.knit.solutions.lab2_1.Task2_2Classes;

public class Latte implements Coffee {

    @Override
    public double getCost() {
        return 2.5;
    }

    @Override
    public String getDescription() {
        return "Эспрессо, молоко, пенка";
    }
}
