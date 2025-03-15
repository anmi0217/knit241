package org.knit.solutions.Task10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class Runner implements Runnable {
    private final String name;
    private final CyclicBarrier startBarrier;
    private final CyclicBarrier finishBarrier;
    private final AtomicBoolean raceInterrupted;

    public Runner(String name,
                  CyclicBarrier startBarrier,
                  CyclicBarrier finishBarrier,
                  AtomicBoolean raceInterrupted) {
        this.name = name;
        this.startBarrier = startBarrier;
        this.finishBarrier = finishBarrier;
        this.raceInterrupted = raceInterrupted;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " готов к старту.");
            startBarrier.await();

            System.out.println(name + " начал забег!");
            int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
            long endTime = System.currentTimeMillis() + runTime;

            while (System.currentTimeMillis() < endTime) {
                if (raceInterrupted.get()) {
                    System.out.println(name + " прекращает бег (гонка прервана).");
                    return;
                }
                Thread.sleep(100);
            }

            // Если гонка уже прервана, выбегаем
            if (raceInterrupted.get()) {
                System.out.println(name + " завершает бег (гонка прервана).");
                return;
            }

            if (ThreadLocalRandom.current().nextInt(1, 101) <= 20) {
                if (raceInterrupted.compareAndSet(false, true)) {
                    System.out.println(name + " получил травму и не может продолжить!");
                    finishBarrier.reset();
                }
                return;
            }

            System.out.println(name + " финишировал (за " + runTime + " мс).");
            try {
                finishBarrier.await();
            } catch (BrokenBarrierException ex) {
                System.out.println(name + " не дождался финиш-барьера из-за прерывания гонки.");
            }

        } catch (InterruptedException e) {
            System.out.println(name + " прерван во время забега.");
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            System.out.println(name + " столкнулся с прерыванием барьера (BrokenBarrierException).");
        }
    }
}
