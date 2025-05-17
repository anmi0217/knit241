package org.knit.solutions.org2.lab2;

class SizeDecorator extends CoffeeDecorator {
    private String size;

    SizeDecorator(Coffee coffee, String size) {
        super(coffee);
        this.size = size;
    }

    @Override
    public double getCost() {
        switch (size.toLowerCase()) {
            case "small":
                return super.getCost();
            case "medium":
                return super.getCost() + 0.5;
            case "large":
                return super.getCost() + 1.0;
            default:
                throw new IllegalArgumentException("Неизвестный размер: " + size);
        }
    }

    @Override
    public String getDescription() {
        return "(" + size + ") " + super.getDescription();
    }

    @Override
    public int getCalories() {
        switch (size.toLowerCase()) {
            case "small":
                return super.getCalories();
            case "medium":
                return super.getCalories() + 10;
            case "large":
                return super.getCalories() + 20;
            default:
                throw new IllegalArgumentException("Неизвестный размер: " + size);
        }
    }
}
