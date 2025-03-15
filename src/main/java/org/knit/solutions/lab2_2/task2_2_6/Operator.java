package org.knit.solutions.lab2_2.task2_2_6;

import java.util.concurrent.BlockingQueue;

public class Operator implements Runnable {
    private final BlockingQueue<Detail> warehouseQueue;
    private final BlockingQueue<Detail> assemblerQueue;
    private int checkedDetails = 0;

    public Operator(BlockingQueue<Detail> assemblerQueue, BlockingQueue<Detail> warehouseQueue) {
        this.assemblerQueue = assemblerQueue;
        this.warehouseQueue = warehouseQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(3000);
                Detail detail = assemblerQueue.take();
                warehouseQueue.put(detail);
                System.out.println("\uD83D\uDC68\u200D✈\uFE0FОператор контроля проверил деталь " + detail.getId() + " и отправил на склад");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
