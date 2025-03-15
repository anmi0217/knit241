package org.knit.solutions.lab2_2.task2_2_6;
import java.util.concurrent.BlockingQueue;

public class Assembler implements Runnable{
    private final BlockingQueue<Detail> stampingQueue;
    private final BlockingQueue<Detail> assemblerQueue;

    public Assembler(BlockingQueue<Detail> blockingQueue, BlockingQueue<Detail> assemblerQueue) {
        this.stampingQueue = blockingQueue;
        this.assemblerQueue = assemblerQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(1000);
                Detail detail = stampingQueue.take();
                assemblerQueue.put(detail);
                System.out.println("⚙\uFE0FСборщик обработал заготовку " + detail.getId());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
