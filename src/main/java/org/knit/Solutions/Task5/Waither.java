package org.knit.Solutions.Task5;

class Waither extends Thread {
    private Restaurant restaurant;

    public Waither(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            restaurant.serve();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}