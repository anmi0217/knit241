package org.knit.solutions.org2.lab5;

class Chef implements Runnable {
    private final Restaurant restaurant; //final, чтобы ссылка не могла быть изменена после инициализации

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) { // Повар готовит 10 блюд
                restaurant.cookDish("Блюдо " + i);
                Thread.sleep(500); // Имитация времени приготовления
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Повар прерван.");
        }
    }
}