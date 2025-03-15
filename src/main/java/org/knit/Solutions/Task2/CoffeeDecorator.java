package org.knit.Solutions.Task2;

// 3. Абстрактный класс-декоратор (наследуется от Coffee)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee; // Оборачиваемый объект

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCalories() { return  coffee.getCalories(); }
}
