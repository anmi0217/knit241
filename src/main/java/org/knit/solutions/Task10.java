/*
Группа спортсменов участвует в забеге. Однако перед началом гонки все должны собраться на старте.
Как только все участники будут готовы, забег начнётся одновременно.
Используйте CyclicBarrier, чтобы синхронизировать запуск гонки.

Каждый бегун стартует одновременно, затем бежит разное время (симулируется Thread.sleep), после чего финиширует.
Как только все бегуны завершат дистанцию, программа выводит сообщение о завершении гонки.
 */


package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.annotations.Discription;
import org.knit.solutions.org2.lab10.Runner;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
@TaskDescription(taskNumber = 10, taskDescription = "Гонка бегунов с использованием CyclicBarrier")
public class Task10 implements Solution {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество бегунов: ");
        int numberOfRunners = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Создаем барьер для старта с обработчиком события при достижении барьера
        CyclicBarrier startBarrier = new CyclicBarrier(numberOfRunners,
                () -> System.out.println("Все бегуны готовы. Гонка начинается!"));

        // Создаем пул потоков для бегунов
        ExecutorService executor = Executors.newFixedThreadPool(numberOfRunners);

        System.out.println("Подготовка " + numberOfRunners + " бегунов...");

        // Создаем и запускаем бегунов
        for (int i = 1; i <= numberOfRunners; i++) {
            executor.execute(new Runner(startBarrier, i));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // Класс бегуна
    private static class Runner implements Runnable {
        private final CyclicBarrier barrier;
        private final int runnerNumber;

        public Runner(CyclicBarrier barrier, int runnerNumber) {
            this.barrier = barrier;
            this.runnerNumber = runnerNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Бегун " + runnerNumber + " готов к старту");
                barrier.await(); // Ожидание готовности всех бегунов

                // Имитация бега
                int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
                Thread.sleep(runTime);

                System.out.println("Бегун " + runnerNumber + " финишировал за " + runTime + " мс");
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
                System.out.println("Бегун " + runnerNumber + " прерван");
            }
        }
    }
}