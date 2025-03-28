package org.knit.solutions.ClassesSem2.lab1.task2;

public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75 * coffee.getSize(); // Добавляем цену оливок
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 25 * coffee.getSize();
    }

    @Override
    public void setSize(int size) {
        coffee.setSize(size);
    }
}
