package org.knit.solutions.labor2.lab2.task5;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {

    private final int CAPACITY = 3;
    private final Queue<Integer> mealsQueue = new LinkedList<>();

    public synchronized void cook(int number) {
        while (mealsQueue.size() >= CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        mealsQueue.add(number);
        System.out.println("Повар приготовил блюдо " + number);
        notify();
    }

    public synchronized void serve() {
        while (mealsQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Официант подал блюдо " + mealsQueue.poll());
        notify();
    }
}

