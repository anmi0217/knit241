package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.labor2.lab3.Runner;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@TaskDescription(taskNumber = 10, taskDescription = "Симуляция забега бегунов с использованием CyclicBarrier")
public class Task10 implements Solution {
    @Override
    public void execute() {
        final int numRunners = 5;

        CyclicBarrier barrier = new CyclicBarrier(numRunners, () ->
                System.out.println("Все бегуны на старте! Гонка началась!"));

        ExecutorService executor = Executors.newFixedThreadPool(numRunners);

        for (int i = 1; i <= numRunners; i++) {
            executor.execute(new Runner(barrier, i));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Не все бегуны завершили гонку в отведенное время");
            }
            System.out.println("Гонка завершена!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Гонка была прервана!");
        }
    }
}
