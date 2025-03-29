package org.knit.solutions.TaskSem2;

import org.knit.solutions.ClassesSem2.lab3.Runner;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/**
 * Задача 10: Гонка бегунов с использованием CyclicBarrier 🏃‍♂️🏃‍♀️
 * <p>
 * Описание:
 * - Группа спортсменов участвует в забеге. Все должны собраться на старте перед гонкой.
 * - Как только все участники будут готовы, забег начинается одновременно.
 * <p>
 * Требования:
 * - Использовать CyclicBarrier для синхронизации начала забега.
 * - Реализовать класс Runner, который будет выполняться в потоке.
 * - Каждый бегун стартует одновременно, затем бежит разное время (симуляция с использованием Thread.sleep).
 * - После завершения всех бегунов программа сообщает о завершении гонки.
 * <p>
 * Дополнительное задание (по желанию):
 * - Добавить ещё одну CyclicBarrier, чтобы дождаться всех бегунов на финише перед выводом финального сообщения.
 * - Добавить возможность прерывания гонки (например, если один из бегунов "травмируется" и не может продолжить).
 */
@TaskDescription(taskNumber = 10,
        taskDescription = "Гонка бегунов с использованием CyclicBarrier",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_10 implements Solution {
    public void execute() {
        while (true) {
            startRace();
            try {
                Thread.sleep(10000); // Ждём 10 секунд перед следующей гонкой
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void startRace() {
        int runners = 5;
        System.out.println("Гонка скоро начнётся, Спортсмены, подойти к старту!");
        CyclicBarrier startBarrier = new CyclicBarrier(runners, () -> {
            System.out.println("Гонка началась!");
        });

        CyclicBarrier finishBarrier = new CyclicBarrier(runners, () -> {
            System.out.println("Гонка Завершилась!");
        });
        ExecutorService executorService = Executors.newFixedThreadPool(runners);

        for (int i = 1; i <= runners; i++) {
            executorService.submit(new Runner(i, startBarrier, finishBarrier));
        }

        executorService.shutdown();
    }
}
