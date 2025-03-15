package org.labs.Tasks2.Task9;

import java.util.concurrent.BlockingQueue;

public class ShipmentWorker implements Runnable {
    private final BlockingQueue<String> warehouseQueue;
    private int shippedCount = 0;

    public ShipmentWorker(BlockingQueue<String> warehouseQueue) {
        this.warehouseQueue = warehouseQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String detail = warehouseQueue.take();

                if (Main.POISON_PILL.equals(detail)) {
                    System.out.println(Thread.currentThread().getName()
                            + ": получил сигнал завершения. Всего отгружено: " + shippedCount);
                    break;
                }

                shipDetail(detail);

                Thread.sleep((long) (Math.random() * 2000 + 500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": был(а) прерван(а).");
        }

        System.out.println(Thread.currentThread().getName() + ": закончил(а) работу.");
    }

    private void shipDetail(String detail) {
        shippedCount++;
        System.out.println(Thread.currentThread().getName()
                + ": " + detail + " отгружена покупателю. Всего отгружено: " + shippedCount);
    }
}
