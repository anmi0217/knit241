package org.knit.solutions.lab2_3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private int id;
    private CyclicBarrier barrier;

    public Runner(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2500));
            System.out.println("Бегун " + id + " ожидает других игроков на старте...");
            barrier.await();
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2500));
            System.out.println("Бегун " + id + " добежал до финиша");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
