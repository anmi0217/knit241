package org.knit.Solutions.Task5;

public class Restaurant {
    private int dishes = 0;
    private final int MAX_DISHES = 3;

    public synchronized void cook() {
        while (dishes >= MAX_DISHES) {
            try {
                System.out.println("Повар ждет, пока официант заберет блюда...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        dishes++;
        System.out.println("Повар приготовил блюдо. Блюд на подносе: " + dishes);
        notify();
    }

    public synchronized void serve() {
        while (dishes == 0) {
            try {
                System.out.println("Официант ждет, пока повар приготовит блюда...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        dishes--;
        System.out.println("Официант подал блюдо. Осталось на подносе: " + dishes);
        notify();
    }
}
