package org.knit.solutions.lab1.task2;

public class SizeDecorator extends CoffeeDecorator {
    private final String label;

    public SizeDecorator(Coffee base, String label) {
        super(base);
        this.label = label.toLowerCase();

        switch (this.label) {
            case "small" -> base.setSize(1);
            case "medium" -> base.setSize(2);
            case "large" -> base.setSize(3);
            default -> base.setSize(1);
        }
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", размер: \"" + label + "\"";
    }
}
