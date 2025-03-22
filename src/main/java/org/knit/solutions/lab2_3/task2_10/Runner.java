package org.knit.solutions.lab2_3.task2_10;

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
            System.out.println("Бегун " + id + " готовится к старту.");
            barrier.await(); // Ожидание всех бегунов
            int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
            System.out.println("Бегун " + id + " стартовал!");
            Thread.sleep(runTime);
            System.out.println("Бегун " + id + " финишировал за " + runTime + " мс.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
