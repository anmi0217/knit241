package Semestr_2.Task2;

// 4. Конкретные декораторы (добавки)
class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50; // Добавляем цену сыра
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }

    @Override
    public double getCalories() { return super.getCalories() + 15.;}
}

