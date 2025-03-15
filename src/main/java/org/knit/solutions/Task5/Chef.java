package org.labs.Tasks2.Task5;

public class Chef extends Thread {
    private final Restaurant restaurant;
    private final String chefName;

    public Chef(String chefName, Restaurant restaurant) {
        this.chefName = chefName;
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                restaurant.cookDish(chefName);
                Thread.sleep((long) (Math.random() * 1000 + 500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(chefName + " был прерван во время готовки.");
        }
        System.out.println(chefName + " закончил работу.");
    }
}