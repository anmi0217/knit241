package org.knit.solutions.task32;

import java.util.LinkedList;
import java.util.Queue;

public class Storage {
    private final int CAPACITY = 5;
    private final Queue<Integer> productsQueue = new LinkedList<>();

    public synchronized void produce(int productId) {
        while (productsQueue.size() >= CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        productsQueue.add(productId);
        System.out.println("Производитель привёз товар " + productId);
        notify();
    }

    public synchronized void consume() {
        while (productsQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Потребитель забрал товар " + productsQueue.poll());
        notify();
    }
}
