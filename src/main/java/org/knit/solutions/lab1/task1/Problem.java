package org.knit.solutions.lab1.task1;

// Представляет проблему или заявку на рассмотрение
public class Problem {
    private final String description;
    private final int amount;

    public Problem(String description, int amount) {
        this.description = description;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Запрос: " + description + ", Сложность: " + amount;
    }
}
