package org.knit.solutions.lab1.task2;

// 3. Абстрактный класс-декоратор (наследуется от Pizza)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee base;

    public CoffeeDecorator(Coffee base) {
        this.base = base;
    }

    @Override
    public double getCost() {
        return base.getCost();
    }

    @Override
    public String getDescription() {
        return base.getDescription();
    }

    @Override
    public int getCalories() {
        return base.getCalories();
    }

    @Override
    public int getSize() {
        return base.getSize();
    }

    @Override
    public void setSize(int size) {
        base.setSize(size);
    }
}
