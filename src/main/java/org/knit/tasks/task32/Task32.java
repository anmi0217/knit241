package org.knit.tasks.task32;

public class Task32 {
    public static void main(String[] args) {
        Storage storage = new Storage();
        int productsNumber = 10;
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < productsNumber; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                storage.produce(i);
            }
        });
        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < productsNumber; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                storage.consume();
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
