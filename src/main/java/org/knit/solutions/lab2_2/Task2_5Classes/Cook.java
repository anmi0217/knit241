package org.knit.solutions.lab2_2.Task2_5Classes;


public class Cook extends Thread{
    private final Restaurant restaurant;

    public Cook(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                restaurant.cookDish();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
