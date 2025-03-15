package org.knit.solutions.Task9;

import java.util.concurrent.BlockingQueue;

public class StampingWorker implements Runnable {
    private final BlockingQueue<String> stampingQueue;
    private final String poisonPill;

    public StampingWorker(BlockingQueue<String> stampingQueue, String poisonPill) {
        this.stampingQueue = stampingQueue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                produceBlank(i);
                Thread.sleep((long) (Math.random() * 1000 + 500));
            }

            stampingQueue.put(poisonPill);
            System.out.println(Thread.currentThread().getName()
                    + ": закончил(а) работу и отправил сигнал завершения.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": был(а) прерван(а).");
        }
    }

    private void produceBlank(int i) throws InterruptedException {
        String blank = "Заготовка " + i;
        stampingQueue.put(blank);
        System.out.println(Thread.currentThread().getName() + ": " + blank + " создана");
    }
}

