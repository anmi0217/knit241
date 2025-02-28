package org.knit.lab10;
import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public double sum() {
        double total = 0.0;

        for (T item : items) {
            total += item.doubleValue();
        }

        return total;
    }
}