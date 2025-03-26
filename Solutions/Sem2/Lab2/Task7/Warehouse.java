package org2.lab7;

import java.util.LinkedList;
import java.util.Queue;

class Warehouse {
    private final Queue<Integer> goods = new LinkedList<>(); // Склад для товаров
    private final int CAPACITY = 5; // Максимальная вместимость склада

    // Метод для производителя (добавление товаров)
    public synchronized void produce(int item) throws InterruptedException {
        while (goods.size() == CAPACITY) { // Если склад полон, производитель ждет
            System.out.println("Склад полон. Производитель ждет...");
            wait();
        }

        goods.add(item); // Добавляем товар на склад
        System.out.println("Производитель создал товар: " + item + ". Товаров на складе: " + goods.size());

        notifyAll(); // Уведомляем потребителя, что появился новый товар
    }

    // Метод для потребителя (забор товаров)
    public synchronized void consume() throws InterruptedException {
        while (goods.isEmpty()) { // Если склад пуст, потребитель ждет
            System.out.println("Склад пуст. Потребитель ждет...");
            wait();
        }

        int item = goods.poll(); // Забираем товар со склада
        System.out.println("Потребитель забрал товар: " + item + ". Товаров на складе: " + goods.size());

        notifyAll(); // Уведомляем производителя, что можно создавать новый товар
    }
}
