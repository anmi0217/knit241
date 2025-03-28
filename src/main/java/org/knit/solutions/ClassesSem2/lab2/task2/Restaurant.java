package org.knit.solutions.ClassesSem2.lab2.task2;

public class Restaurant {
    private final int MAX_DISHES = 3;
    private int dishes = 0;
    public synchronized void cook() {
        while (dishes == MAX_DISHES) {
            try {
                System.out.println("Повар ждет: поднос заполнен!");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        dishes++;
        System.out.println("Повар приготовил блюдо (Всего на подносе: " + dishes + ")");
        notifyAll();
    }

    public synchronized void serve() {
        while (dishes == 0) {
            try {
                System.out.println("Официант ждет: поднос пуст!");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        dishes--;
        System.out.println("Официант подал блюдо клиенту (Осталось на подносе: " + dishes + ")");
        notifyAll();
    }
}
