package org.knit.solutions.ClassesSem1.lab10.Task20;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private List<T> numbers;

    public Box() {
        numbers = new ArrayList<>();
    }

    public void add(T number) {
        numbers.add(number);
    }

    public double sum() {
        double sum = 0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
