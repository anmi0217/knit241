package org.knit.solutions;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

import org.knit.TaskDescription;
import org.knit.solutions.Task10.Runner;

/*
📌 Описание
Группа спортсменов участвует в забеге. Однако перед началом гонки все должны собраться на старте.
Как только все участники будут готовы, забег начнётся одновременно.
Используйте CyclicBarrier, чтобы синхронизировать запуск гонки.

Каждый бегун стартует одновременно, затем бежит разное время (симулируется Thread.sleep), после чего финиширует.
Как только все бегуны завершат дистанцию, программа выводит сообщение о завершении гонки.

🎯 Требования к задаче:
1) Создать CyclicBarrier для синхронизации начала забега.
2) Реализовать класс Runner, который:
   - Ожидает старта (barrier.await()).
   - Симулирует бег (Thread.sleep(randomTime)).
   - Выводит сообщение о финише.
3) После финиша всех участников программа должна сообщить, что гонка завершена.
4) Количество бегунов задаётся константой (или параметром).

🔧 Подсказка
Используйте Executors.newFixedThreadPool() для управления потоками.
Для генерации случайного времени бега используйте ThreadLocalRandom.current().nextInt(500, 3000).

🔹 Доп. задание (выполнено в коде ниже):
- Есть второй barrier, ожидающий всех бегунов на финише.
- Возможность прерывания гонки, если один из бегунов "получил травму".
 */

@TaskDescription(taskNumber = 10, taskDescription = "Гонка бегунов с использованием CyclicBarrier")
public class Task10Solution implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 10 запущена");

        final int numRunners = 5;

        AtomicBoolean raceInterrupted = new AtomicBoolean(false);

        CyclicBarrier startBarrier = new CyclicBarrier(numRunners, () ->
                System.out.println("Все участники готовы. Начинаем забег!")
        );

        CyclicBarrier finishBarrier = new CyclicBarrier(numRunners, () ->
                System.out.println("Все бегуны финишировали. Забег завершён!")
        );

        ExecutorService executor = Executors.newFixedThreadPool(numRunners);
        try {
            for (int i = 0; i < numRunners; i++) {
                String runnerName = "Бегун-" + (i + 1);
                executor.submit(new Runner(runnerName, startBarrier, finishBarrier, raceInterrupted));
            }
        } finally {
            executor.shutdown();
        }

        try {
            boolean finishedInTime = executor.awaitTermination(10, TimeUnit.SECONDS);
            if (!finishedInTime) {
                System.out.println("Внимание: не все бегуны успели финишировать за 10 секунд.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван во время ожидания завершения забега.");
            Thread.currentThread().interrupt();
        }

        if (raceInterrupted.get()) {
            System.out.println("Забег был прерван из-за травмы одного из бегунов.");
        }
    }
}
