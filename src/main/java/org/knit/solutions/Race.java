package org.knit.solutions;
import org.knit.TaskDescription;
import org.knit.solutions.lab2_3.task2_10.Runner;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@TaskDescription(taskNumber = 10, taskDescription = "Гонка")
public class Race implements Solution {

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
            executor.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println("Гонка завершена!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
