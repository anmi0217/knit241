package org.knit.solutions.labor2.lab2.task7;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private final int CAPACITY = 5;
    private final Queue<Integer> productQueue = new LinkedList<>();

    public synchronized void add(int number) {
        while (productQueue.size() == CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        productQueue.add(number);
        System.out.println("На склад добавили товар " + number);
        notify();
    }

    public synchronized void take() {
        while (productQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Со склада забрали товар " + productQueue.poll());
        notify();
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                producerConsumer.add(i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                producerConsumer.take();
            }
        });

        producer.start();
        consumer.start();
    }
}

