package org.knit.solutions.Tasks2Semestr;

import org.knit.solutions.lab3.Runner;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

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
@TaskDescription(
        taskNumber = 10,
        taskDescription = "Гонка бегунов с использованием CyclicBarrier",
        href = "org/knit/solutions/taskExampleClasses/README.md"
)
public class Task2_10 implements Solution {

    @Override
    public void execute() {
        while (true) {
            launchRace();
            try {
                Thread.sleep(10000); // Пауза перед новой гонкой
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void launchRace() {
        final int totalRunners = 5;

        System.out.println("Подготовка к забегу... Ждём всех участников.");

        CyclicBarrier start = new CyclicBarrier(totalRunners, () ->
                System.out.println("Все готовы! Забег начинается!"));

        CyclicBarrier finish = new CyclicBarrier(totalRunners, () ->
                System.out.println("Все участники завершили дистанцию. Забег окончен."));

        ExecutorService pool = Executors.newFixedThreadPool(totalRunners);

        for (int i = 1; i <= totalRunners; i++) {
            pool.submit(new Runner(i, start, finish));
        }

        pool.shutdown();
    }
}
