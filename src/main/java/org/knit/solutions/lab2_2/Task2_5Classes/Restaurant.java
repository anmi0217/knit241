package org.knit.solutions.lab2_2.Task2_5Classes;


public class Restaurant {
    private int dish;


    public synchronized void cookDish() throws InterruptedException {
        while (dish >= 3) {
            wait();
        }

        dish += 1;
        System.out.println("Повар приготовил блюдо. Всего: " + dish);

        notify();
    }

    public synchronized void takeDish() throws InterruptedException {
        while (dish <= 0) {
            wait();
        }

        dish -= 1;
        System.out.println("Официант забрал одно блюдо. Всего: " + dish);

        notify();
    }
}
