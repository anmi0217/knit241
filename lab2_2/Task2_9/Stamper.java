package org.dina.lab2_2.Task2_9;

import java.util.concurrent.BlockingQueue;

public class Stamper implements Runnable {
    private final BlockingQueue<Detail> stampingQueue;
    private int lastDetailId = 0;

    public Stamper(BlockingQueue<Detail> blockingQueue) {
        this.stampingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (lastDetailId < 3) {
            try {
                stampingQueue.put(new Detail(++lastDetailId));
                System.out.println("Штамповщик сделал заготовку " + lastDetailId);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Штамповщик закончил работу.");
    }
}
