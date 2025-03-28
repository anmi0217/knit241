package org.knit.solutions.ClassesSem2.lab1.task2;

// 4. Конкретные декораторы (добавки)
public class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50 * coffee.getSize();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", карамель";
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
