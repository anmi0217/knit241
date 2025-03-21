package org2.lab5;

import java.util.LinkedList;
import java.util.Queue;

class Restaurant {
    private final Queue<String> tray = new LinkedList<>(); // Поднос для блюд
    private final int TRAY_CAPACITY = 3; // Максимальное количество блюд на подносе

    // Метод для повара (добавление блюд на поднос)
    public synchronized void cookDish(String dish) throws InterruptedException {
        while (tray.size() >= TRAY_CAPACITY) { // Если поднос полон, повар ждет
            System.out.println("Повар ждет, так как поднос полон...");
            wait();
        }

        tray.add(dish); // Добавляем блюдо на поднос
        System.out.println("Повар приготовил: " + dish + ". Блюд на подносе: " + tray.size());

        notifyAll(); // Уведомляем официанта, что есть блюда
    }

    // Метод для официанта (взятие блюд с подноса)
    public synchronized void serveDish() throws InterruptedException {
        while (tray.isEmpty()) { // Если поднос пуст, официант ждет
            System.out.println("Официант ждет, так как поднос пуст...");
            wait();
        }

        String dish = tray.poll(); // Берем блюдо с подноса
        System.out.println("Официант подал: " + dish + ". Блюд на подносе: " + tray.size());

        notifyAll(); // Уведомляем повара, что можно готовить еще
    }
}
