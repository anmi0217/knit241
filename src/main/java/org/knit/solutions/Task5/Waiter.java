package org.labs.Tasks2.Task5;

public class Waiter extends Thread {
    private final Restaurant restaurant;
    private final String waiterName;

    public Waiter(String waiterName, Restaurant restaurant) {
        this.waiterName = waiterName;
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                restaurant.serveDish(waiterName);
                Thread.sleep((long) (Math.random() * 1500 + 500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(waiterName + " был прерван во время работы.");
        }
        System.out.println(waiterName + " закончил работу.");
    }
}