package org.knit.Solutions.Task2;

// 2. Конкретная реализация кофе (базовый объект)
class EspressoCoffee implements Coffee {
    @Override
    public double getCost() {
        return 5.00; // Цена базового кофе
    }

    @Override
    public String getDescription() {
        return "Эспрессо ( плотный кофейный напиток )";
    }

    @Override
    public double getCalories() { return  10.; }
}
