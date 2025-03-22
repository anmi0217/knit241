package org.knit.solutions.lab2_2.Task2_5Classes;

public class Waiter extends Thread{
    private final Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                restaurant.takeDish();
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
