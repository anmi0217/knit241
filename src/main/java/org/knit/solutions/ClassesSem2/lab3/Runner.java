package org.knit.solutions.ClassesSem2.lab3;

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
            System.out.println("Спортсмен " + id + " подошёл к старту");
            startBarrier.await();

            int randomTime = ThreadLocalRandom.current().nextInt(500, 6000);
            if (randomTime >= 5000) {
                System.out.println("Спортсмен " + id + " получил травму и не сможет продолжить гонку!");
                finishBarrier.await();

            } else {
                Thread.sleep(randomTime);
                System.out.println("Спортсмен " + id + " закончил гонку со временем: " + (double) randomTime / 1000);

                finishBarrier.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
