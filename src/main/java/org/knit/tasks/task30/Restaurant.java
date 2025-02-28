package org.knit.tasks.task30;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    private final int MEALS_CAPACITY = 3;
    private final Queue<String> mealsQueue = new LinkedList<>();

    public synchronized void cook(String mealName) {
        while (mealsQueue.size() >= MEALS_CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        mealsQueue.add(mealName);
        System.out.println("Повар приготовил блюдо " + mealName);
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
