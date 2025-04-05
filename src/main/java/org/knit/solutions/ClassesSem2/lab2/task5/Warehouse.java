package org.knit.solutions.ClassesSem2.lab2.task5;

public class Warehouse {
    private int goods = 0; // Количество товаров на складе
    private final int MAX_GOODS = 5; // Максимальное количество товаров

    // Метод для добавления товара (производитель)
    public synchronized void produce() {
        while (goods >= MAX_GOODS) {
            try {
                System.out.println("Склад полный, производитель ждет");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        goods++;
        System.out.println("Производитель добавил товар. На складе: " + goods);
        notify();
    }

    // Метод для забора товара (потребитель)
    public synchronized void consume() {
        while (goods == 0) {
            try {
                System.out.println("Товары закончились, потребитель ждет");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        goods--;
        System.out.println("Потребитель забрал товар. На складе: " + goods);
        notify();
    }
}
