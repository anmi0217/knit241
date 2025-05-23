package org.knit.solutions.lab2.task5;

public class Warehouse {
    private int goods = 0; // Текущий запас на складе
    private final int MAX_GOODS = 5; // Максимально допустимое количество

    // Производитель добавляет товар
    public synchronized void produce() {
        while (goods >= MAX_GOODS) {
            try {
                System.out.println("Склад полон. Производитель ждёт.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        goods++;
        System.out.println("Производитель добавил товар. Текущее количество: " + goods);
        notifyAll();
    }

    // Потребитель забирает товар
    public synchronized void consume() {
        while (goods == 0) {
            try {
                System.out.println("Склад пуст. Потребитель ждёт.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        goods--;
        System.out.println("Потребитель забрал товар. Осталось: " + goods);
        notifyAll();
    }
}
