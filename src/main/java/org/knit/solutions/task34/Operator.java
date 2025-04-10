package org.knit.solutions.task34;

import java.util.concurrent.BlockingQueue;

public class Operator implements Runnable {
    private final int detailsNumber;
    private final BlockingQueue<Detail> detailsQueue;
    private final BlockingQueue<Detail> storageQueue;

    public Operator(
            int detailsNumber,
            BlockingQueue<Detail> workpiecesQueue,
            BlockingQueue<Detail> detailsQueue
    ) {
        this.detailsNumber = detailsNumber;
        this.detailsQueue = workpiecesQueue;
        this.storageQueue = detailsQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < detailsNumber; i++) {
            try {
                Detail detail = detailsQueue.take();
                Thread.sleep(1000);
                storageQueue.put(detail);
                System.out.println("Оператор проверил деталь " + detail.getId());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
