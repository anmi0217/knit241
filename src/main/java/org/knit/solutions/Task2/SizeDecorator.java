package org.labs.Tasks2.Task2;

public class SizeDecorator extends CoffeeDecorator {
    private final String size;

    public SizeDecorator(Coffee coffee, String size) {
        super(coffee);
        this.size = size;
    }

    @Override
    public double getCost() {
        if (size.equalsIgnoreCase("medium")) {
            return coffee.getCost() + 0.5;
        } else if (size.equalsIgnoreCase("large")) {
            return coffee.getCost() + 1.0;
        }
        return coffee.getCost();
    }

    @Override
    public int getCalories() {
        if (size.equalsIgnoreCase("medium")) {
            return coffee.getCalories() + 20;
        } else if (size.equalsIgnoreCase("large")) {
            return coffee.getCalories() + 40;
        }
        return coffee.getCalories();
    }

    @Override
    public String getDescription() {
        return size.toUpperCase() + " " + coffee.getDescription();
    }
}
