package Semestr_2.Task2;

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.00; // Добавляем цену сахара
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", сахар";
    }

    @Override
    public double getCalories() { return  super.getCalories() + 40.;}
}
