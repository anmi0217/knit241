package org.dina.lab2_2.Task2_9;

import java.util.concurrent.BlockingQueue;

public class Operator implements Runnable {
    private final double PROBABILITY = 0.2;
    private final BlockingQueue<Detail> stampingQueue;
    private final BlockingQueue<Detail> reassemblingQueue;
    private final BlockingQueue<Detail> assemblingQueue;
    private final BlockingQueue<Detail> warehouseQueue;
    private final Factory factory;

    public Operator(
            BlockingQueue<Detail> stampingQueue,
            BlockingQueue<Detail> reassemblingQueue,
            BlockingQueue<Detail> assemblingQueue,
            BlockingQueue<Detail> warehouseQueue,
            Factory factory
    ) {
        this.stampingQueue = stampingQueue;
        this.reassemblingQueue = reassemblingQueue;
        this.assemblingQueue = assemblingQueue;
        this.warehouseQueue = warehouseQueue;
        this.factory = factory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Detail detail = assemblingQueue.take();
                Thread.sleep(2000);
                if (Math.random() > PROBABILITY) {
                    warehouseQueue.put(detail);
                    System.out.println("Оператор проверил деталь " + detail.getId() + " и отправил ее на склад");

                    if (stampingQueue.isEmpty() && assemblingQueue.isEmpty()) {
                        factory.setWorkFinished(true);
                        System.out.println("Оператор закончил работу.");
                        break;
                    }
                } else {
                    reassemblingQueue.put(detail);
                    System.out.println("Оператор проверил деталь " + detail.getId() + " и отправил ее на доработку");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
