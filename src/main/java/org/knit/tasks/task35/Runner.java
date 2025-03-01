package org.knit.tasks.task35;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private final int id;
    private final CyclicBarrier startBarrier;
    private final CyclicBarrier finishBarrier;

    public Runner(int id, CyclicBarrier startBarrier, CyclicBarrier finishBarrier) {
        this.id = id;
        this.startBarrier = startBarrier;
        this.finishBarrier = finishBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 3000));
            System.out.println("Бегун " + id + " ожидает начала гонки.");
            startBarrier.await();
            System.out.println("Бегун " + id + " начал забег.");
            int raceTime = ThreadLocalRandom.current().nextInt(3000, 5000);
            Thread.sleep(raceTime);
            System.out.println("Бегун " + id + " завершил забег за " + raceTime + " мс.");
            finishBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace(System.err);
        }
    }
}
