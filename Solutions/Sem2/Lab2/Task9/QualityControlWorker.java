package org2.lab9;

import java.util.concurrent.BlockingQueue;

// оператор контроля качества
class QualityControlWorker implements Runnable {
    private final BlockingQueue<Part> inputQueue;
    private final BlockingQueue<Part> warehouse; // Очередь для отправки деталей на склад

    public QualityControlWorker(BlockingQueue<Part> inputQueue, BlockingQueue<Part> warehouse) {
        this.inputQueue = inputQueue;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Part part = inputQueue.take(); // Берем готовую деталь из очереди
                System.out.println("Оператор контроля: Деталь " + part.getId() + " проверена и отправлена на склад");
                warehouse.put(part); // Отправляем деталь на склад
                Thread.sleep(800); // Имитация времени проверки
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Оператор контроля прерван.");
        }
    }
}