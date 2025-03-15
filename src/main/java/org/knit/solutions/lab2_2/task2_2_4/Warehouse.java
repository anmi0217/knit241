package org.knit.solutions.lab2_2.task2_2_4;

import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {
    private final int max_products = 5;
    private Queue<String> warehouseQueue = new LinkedList<>();

    public synchronized void manufacturer(String name) throws InterruptedException {
        while (warehouseQueue.size() >= max_products) {
            System.out.println("Склад заполнен, производитель пока не может производить товары....");
            wait();
        }
        warehouseQueue.add(name);
        System.out.println("Производитель произвел товар " + name);
        Thread.sleep(500);
        notify();
    }

    public synchronized void consumer() throws InterruptedException {
        while (warehouseQueue.isEmpty()){
            System.out.println("Производитель еще ничего не произвел...");
            wait();
        }
        System.out.println("Потребитель забрал товар " + warehouseQueue.poll());
        notify();
    }
}
