package org.knit.solutions.lab1.task2;

// 4. Конкретные декораторы (добавки)
public class Caramel extends CoffeeDecorator {
    public Caramel(Coffee base) {
        super(base);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.4 * base.getSize();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", с карамелью";
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 30 * base.getSize();
    }
}
