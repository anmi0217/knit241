package org.knit.solutions.task34;

import java.util.concurrent.BlockingQueue;

public class Assembler implements Runnable {
    private final int detailsNumber;
    private final BlockingQueue<Detail> workpiecesQueue;
    private final BlockingQueue<Detail> detailsQueue;

    public Assembler(
            int detailsNumber,
            BlockingQueue<Detail> workpiecesQueue,
            BlockingQueue<Detail> detailsQueue
    ) {
        this.detailsNumber = detailsNumber;
        this.workpiecesQueue = workpiecesQueue;
        this.detailsQueue = detailsQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < detailsNumber; i++) {
            try {
                Detail detail = workpiecesQueue.take();
                Thread.sleep(1000);
                detailsQueue.put(detail);
                System.out.println("Сборщик обработал деталь " + detail.getId());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
