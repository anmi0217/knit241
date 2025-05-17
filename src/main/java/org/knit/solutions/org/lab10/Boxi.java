//20
package org.knit.solutions.org.lab10;

import java.util.ArrayList;
import java.util.List;

// Класс Box с ограничением типа T extends Number
class Box<T extends Number> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public Number sum() {
        double total = 0.0;
        for (T item : items) {
            total += item.doubleValue();
        }
        if (items.size() > 0 && items.get(0) instanceof Integer) {
            return (int) total;
        }
        return total;
    }
}

public class Boxi {
    public static void main(String[] args) {
        // Пример с целыми числами
        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        integerBox.add(20);
        System.out.println("Сумма для целых чисел: " + integerBox.sum());

        // Пример с вещественными числами
        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        System.out.println("Сумма для вещественных чисел: " + doubleBox.sum());
    }
}