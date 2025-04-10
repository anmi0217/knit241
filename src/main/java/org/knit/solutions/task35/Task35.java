package org.knit.solutions.task35;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task35 {
    public static void main(String[] args) {
        int runnersNumber = 5;
        CyclicBarrier startBarrier = new CyclicBarrier(runnersNumber, () ->
                System.out.println("Все бегуны готовы к старту. Гонка начинается.")
        );
        CyclicBarrier finishBarrier = new CyclicBarrier(runnersNumber, () ->
                System.out.println("Гонка завершена.")
        );
        ExecutorService executorService = Executors.newFixedThreadPool(runnersNumber);
        for (int i = 0; i < runnersNumber; i++) {
            executorService.submit(new Runner(i, startBarrier, finishBarrier));
        }
        executorService.shutdown();
    }
}
