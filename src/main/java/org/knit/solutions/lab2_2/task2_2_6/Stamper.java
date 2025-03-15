package org.knit.solutions.lab2_2.task2_2_6;

import java.util.concurrent.BlockingQueue;

public class Stamper implements Runnable{
    private final BlockingQueue<Detail> stamperQueue;

    public Stamper(BlockingQueue<Detail> blockingQueue) {
        this.stamperQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(2500);
                Detail detail = new Detail(i);
                stamperQueue.put(detail);
                System.out.println("\uD83D\uDD29Штамповщик сделал заготовку " + detail.getId());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
