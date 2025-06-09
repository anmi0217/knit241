/*
Группа спортсменов участвует в забеге. Однако перед началом гонки все должны собраться на старте.
Как только все участники будут готовы, забег начнётся одновременно.
Используйте CyclicBarrier, чтобы синхронизировать запуск гонки.

Каждый бегун стартует одновременно, затем бежит разное время (симулируется Thread.sleep), после чего финиширует.
Как только все бегуны завершат дистанцию, программа выводит сообщение о завершении гонки.
 */


package org2.lab10;
import org2.annotations.Discription;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Discription(value = 10, name = "Гонка бегунов с использованием CyclicBarrier ")
public class Task10 {
    public static void main(String[] args) {
        int numberOfRunners = 5; // Количество бегунов (можно задать через аргументы командной строки)
        if (args.length > 0) {
            numberOfRunners = Integer.parseInt(args[0]);
        }

        // Барьер для старта (ждем всех бегунов)
        CyclicBarrier startBarrier = new CyclicBarrier(numberOfRunners, () -> {
            System.out.println("Все бегуны готовы. Гонка начинается!");
        });

        // Барьер для финиша (ждем всех бегунов)
        CyclicBarrier finishBarrier = new CyclicBarrier(numberOfRunners, () -> {
            System.out.println("Все бегуны финишировали. Гонка завершена!");
        });

        // Счетчик завершивших бегунов
        AtomicInteger finishedRunners = new AtomicInteger(0);

        // Пул потоков для бегунов
        ExecutorService executor = Executors.newFixedThreadPool(numberOfRunners);

        // Создаем и запускаем бегунов
        for (int i = 1; i <= numberOfRunners; i++) {
            executor.execute(new Runner(startBarrier, finishBarrier, i, finishedRunners));
        }

        // Завершаем пул потоков
        executor.shutdown();
    }
}
