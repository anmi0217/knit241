package org.knit.solutions.ClassesSem2.lab1.task2;

public class SizeDecorator extends CoffeeDecorator {
    private String sizeString;

    public SizeDecorator(Coffee coffee, String size) {
        super(coffee);
        this.sizeString = size;
        if (sizeString.equalsIgnoreCase("small")) {
            coffee.setSize(1);
        } else if (sizeString.equalsIgnoreCase("medium")) {
            coffee.setSize(2);
        } else if (sizeString.equalsIgnoreCase("large")) {
            coffee.setSize(3);
        }
    }

    @Override
    public double getCost() {
        return super.getCost();
//        if (sizeString.equalsIgnoreCase("small")) {
//            return baseCost;
//        } else if (sizeString.equalsIgnoreCase("medium")) {
//            return baseCost * coffee.getSize();
//        } else if (sizeString.equalsIgnoreCase("large")) {
//            return baseCost * coffee.getSize();
//        }
//        return baseCost;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", размер: \"" + sizeString + "\"";
    }

    @Override
    public int getCalories() {
        return super.getCalories();
//        if (sizeString.equalsIgnoreCase("small")) {
//            return baseCalories;
//        } else if (sizeString.equalsIgnoreCase("medium")) {
//            return baseCalories * coffee.getSize();
//        } else if (sizeString.equalsIgnoreCase("large")) {
//            return baseCalories * coffee.getSize();
//        }
//        return baseCalories;
    }

    @Override
    public void setSize(int size) {
        coffee.setSize(size);
    }

}
