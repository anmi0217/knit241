package org.knit.solutions.org2.lab10;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Runner implements Runnable {
    private final CyclicBarrier startBarrier; // Барьер для старта
    private final CyclicBarrier finishBarrier; // Барьер для финиша
    private final int runnerId; // Идентификатор бегуна
    private final AtomicInteger finishedRunners; // Счетчик завершивших бегунов

    public Runner(CyclicBarrier startBarrier, CyclicBarrier finishBarrier, int runnerId, AtomicInteger finishedRunners) {
        this.startBarrier = startBarrier;
        this.finishBarrier = finishBarrier;
        this.runnerId = runnerId;
        this.finishedRunners = finishedRunners;
    }

    @Override
    public void run() {
        try {
            // Ожидание старта
            System.out.println("Бегун " + runnerId + " готов к старту.");
            startBarrier.await();

            // Симуляция бега
            int runTime = ThreadLocalRandom.current().nextInt(500, 3000); // Случайное время бега
            System.out.println("Бегун " + runnerId + " начал бег.");
            Thread.sleep(runTime);

            // Финиш
            System.out.println("Бегун " + runnerId + " финишировал за " + runTime + " мс.");
            finishedRunners.incrementAndGet(); // Увеличиваем счетчик завершивших бегунов

            // Ожидание всех бегунов на финише
            finishBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Бегун " + runnerId + " прерван.");
        }
    }
}
