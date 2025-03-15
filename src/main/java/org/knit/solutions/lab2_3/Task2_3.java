package org.knit.solutions.lab2_3;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2_3 {
    static int numRunners = 5;
    public static void Run() {
        ExecutorService exec = Executors.newFixedThreadPool(numRunners);

        CyclicBarrier barrier = new CyclicBarrier(numRunners, () -> {
            System.out.println("Все бегуны готовы к старту!");
        });

        for (int i = 1; i <= numRunners; i++) {
            exec.submit(new Runner(i, barrier));
        }

        exec.shutdown();

        while (!exec.isTerminated()) {

        }

        System.out.println("Гонка завершена!");
    }
}
