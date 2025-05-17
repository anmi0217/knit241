package org.knit.solutions.org2.lab9;

import java.util.concurrent.BlockingQueue;


// сборщик
class AssemblyWorker implements Runnable {
    private final BlockingQueue<Part> inputQueue; // Очередь для получения заготовок
    private final BlockingQueue<Part> outputQueue; // Очередь для передачи готовых деталей

    public AssemblyWorker(BlockingQueue<Part> inputQueue, BlockingQueue<Part> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Part part = inputQueue.take(); // Берем заготовку из очереди
                System.out.println("Сборщик: Заготовка " + part.getId() + " обработана");
                outputQueue.put(part); // Передаем готовую деталь оператору контроля
                Thread.sleep(1000); // Имитация времени сборки
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Сборщик прерван.");
        }
    }
}
