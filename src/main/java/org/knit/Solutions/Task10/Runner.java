package org.knit.Solutions.Task10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

class Runner implements Runnable {
    private final CyclicBarrier startBarrier;
    private final CyclicBarrier finishBarrier;
    private final int id;
    static final AtomicBoolean raceOngoing = new AtomicBoolean(true);
    private static int finishedRunners = 0;
    private static final Object lock = new Object();

    public Runner(int id, CyclicBarrier startBarrier, CyclicBarrier finishBarrier) {
        this.id = id;
        this.startBarrier = startBarrier;
        this.finishBarrier = finishBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Бегун " + id + " готов к старту.");
            startBarrier.await(); // Ждём всех на старте

            int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
            if (ThreadLocalRandom.current().nextDouble() < 0.05) { // 20% шанс травмы
                System.out.println("Бегун " + id + " получил травму и не может продолжить гонку!");
                raceOngoing.set(false);
                finishBarrier.await();
                return;
            }

            Thread.sleep(runTime); // Симуляция бега

            if (!raceOngoing.get()) {
                System.out.println("Гонка завершена досрочно из-за травмы одного из бегунов!");
                System.exit(0);
            }
            ;

            System.out.println("Бегун " + id + " финишировал за " + runTime + " мс.");

            synchronized (lock) {
                finishedRunners++;
            }

            finishBarrier.await(); // Ждём всех финишировавших бегунов
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Бегун " + id + " выбыл из гонки.");
        }
    }
}
