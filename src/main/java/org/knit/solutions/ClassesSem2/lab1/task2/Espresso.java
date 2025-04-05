package org.knit.solutions.ClassesSem2.lab1.task2;

public class Espresso implements Coffee {
    private int size = 1; // Поле для хранения размера

    @Override
    public double getCost() {
        return 5.00 * size;
    }

    @Override
    public String getDescription() {
        return "Эспрессо (Кофейные зёрна, горячая вода)";
    }

    @Override
    public int getCalories() {
        return 75 * size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
