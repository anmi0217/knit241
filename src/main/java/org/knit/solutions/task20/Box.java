package org.knit.solutions.task20;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private final List<T> numbers = new ArrayList<>();

    public void add(T number) {
        numbers.add(number);
    }

    public double sum() {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
