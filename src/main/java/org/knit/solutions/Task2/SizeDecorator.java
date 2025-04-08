package org.knit.solutions.Task2;

public class SizeDecorator extends CoffeeDecorator {
    private final String value;

    public SizeDecorator(Coffee coffee, String value) {
        super(coffee);
        this.value = value;
    }


    @Override
    public double getCost() {
        switch (value) {
            case "low":
                return super.getCost() + 0.3;
            case "medium":
                return super.getCost() + 0.5;
            case "height":
                return super.getCost() + 0.8;
        }
        return super.getCost();
    }

    @Override
    public double getCalories() {
        switch (value) {
            case "low":
                return super.getCalories() + 10;
            case "medium":
                return super.getCalories() + 20.00;
            case "height":
                return super.getCalories() + 30;
        }
        return super.getCalories();
    }

    @Override
    public String getDescription() {
        switch (value) {
            case "low":
                return "LOW " + super.getDescription();
            case "medium":
                return "MEDIUM " + super.getDescription();
            case "height":
                return "HEIGHT " + super.getDescription();
        }
        return super.getDescription();
    }
}
