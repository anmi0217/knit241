package org2.lab9;

import java.util.concurrent.BlockingQueue;


//штамповщик
class StampWorker implements Runnable {
    private final BlockingQueue<Part> queue; // Очередь для передачи заготовок сборщику

    public StampWorker(BlockingQueue<Part> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Part part = new Part(i);
                System.out.println("Штамповщик: Заготовка " + part.getId() + " создана");
                queue.put(part); // Передаем заготовку сборщику
                Thread.sleep(500); // Имитация времени создания заготовки
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Штамповщик прерван.");
        }
    }
}
