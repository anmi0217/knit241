package org.knit.solutions.lab2_2.Task2_7Classes;

import java.util.concurrent.BlockingQueue;


public class Consumer extends Thread {

    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;

    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                consume();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void consume() throws InterruptedException {

        Integer item = queue.take(); // Ждет, если очередь пуста
        System.out.println("Один товар исчез. Всего на складе: " + queue.size());
        Thread.sleep(2000);

    }
}