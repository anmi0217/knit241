package org.knit.solutions.lab2_3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

public class Runner implements Runnable{
    private final String name;
    private final CyclicBarrier barrier;
    private final Random random;

    @Override
    public void run() {
        try {
            System.out.println("Бегун " + name + " готовится...");
            sleep(random.nextInt(2000) + 1500);
            System.out.println(name + " на старте");
            barrier.await();

            sleep(random.nextInt(3000) + 1500);
            System.out.println(name + " пересек финишную черту");
            barrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public Runner(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
        this.random = new Random();
    }
}
