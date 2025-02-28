package org.knit.tasks.task34;

import java.util.concurrent.BlockingQueue;

public class Stamper implements Runnable {
    private final int detailsNumber;
    private final BlockingQueue<Detail> workpiecesQueue;

    public Stamper(
            int detailsNumber,
            BlockingQueue<Detail> workpiecesQueue
    ) {
        this.detailsNumber = detailsNumber;
        this.workpiecesQueue = workpiecesQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < detailsNumber; i++) {
            try {
                Thread.sleep(1000);
                workpiecesQueue.put(new Detail(i));
                System.out.println("Штамповщик сделал деталь " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
