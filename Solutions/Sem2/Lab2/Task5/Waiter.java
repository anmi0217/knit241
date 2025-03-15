package org2.lab5;

class Waiter implements Runnable {
    private final Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) { // Официант подает 10 блюд
                restaurant.serveDish();
                Thread.sleep(1000); // Имитация времени подачи
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Официант прерван.");
        }
    }
}