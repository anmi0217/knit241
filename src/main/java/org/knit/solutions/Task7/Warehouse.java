package org.knit.solutions.Task7;


public class Warehouse {
    private int productCount = 0;
    private final int MAX_CAPACITY = 5;

    public synchronized void produce() throws InterruptedException {
        while (productCount == MAX_CAPACITY) {
            System.out.println("Склад заполнен. Производитель ждет.");
            wait();
        }
        productCount++;
        System.out.println("Производитель создал товар. Товаров на складе: " + productCount);
        notify();
    }


    public synchronized void consume() throws InterruptedException {
        while (productCount == 0) {
            System.out.println("Нет товаров. Потребитель ждет.");
            wait();
        }
        productCount--;
        System.out.println("Потребитель забрал товар. Товаров на складе: " + productCount);
        notify();
    }
}

