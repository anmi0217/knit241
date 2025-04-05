package org.knit.solutions.labor2.lab3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private final CyclicBarrier barrier;
    private final int id;

    public Runner(CyclicBarrier barrier, int id) {
        this.barrier = barrier;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Бегун " + id + " готовится к старту");
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500)); // Время подготовки
            barrier.await(); // Ожидание всех бегунов

            System.out.println("Бегун " + id + " стартовал!");
            int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
            Thread.sleep(runTime);
            System.out.println("Бегун " + id + " финишировал за " + runTime + " мс");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Бегун " + id + " был прерван во время подготовки");
        } catch (BrokenBarrierException e) {
            System.out.println("Бегун " + id + " не смог стартовать из-за сбоя барьера");
        }
    }
}
