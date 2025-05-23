package org.knit.solutions.lab2.task2;

public class Restaurant {
    private final int MAX_CAPACITY = 3;
    private int dishes = 0;

    // Метод для повара: готовит блюдо
    public synchronized void cook() {
        while (dishes == MAX_CAPACITY) {
            try {
                System.out.println("Повар ждёт: поднос полон.");
                wait(); // Ждём, пока официант не освободит место
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        dishes++;
        System.out.println("Повар приготовил блюдо. На подносе теперь: " + dishes);
        notifyAll(); // Сообщаем официанту
    }

    // Метод для официанта: забирает блюдо
    public synchronized void serve() {
        while (dishes == 0) {
            try {
                System.out.println("Официант ждёт: поднос пуст.");
                wait(); // Ждём, пока повар не приготовит что-то
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        dishes--;
        System.out.println("Официант подал блюдо. Осталось на подносе: " + dishes);
        notifyAll(); // Сообщаем повару
    }
}
