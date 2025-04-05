package org.knit.solutions.ClassesSem2.lab1.task1;

public class Problem {
    private String description; // Описание
    private int amount;

    public Problem(String description, int difficulty) {
        this.description = description;
        this.amount = difficulty;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Проблема: " + description + ", Сложность: " + amount;
    }
}
