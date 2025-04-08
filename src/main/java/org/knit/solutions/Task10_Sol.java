package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task10.Runner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.knit.solutions.Task10.Race.Const;

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

@TaskDescription(taskNumber = 10, taskDescription = "Гонка бегунов с использованием CyclicBarrier", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task10_Sol implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 10 запущена");
        ExecutorService executor = Executors.newFixedThreadPool(Const);

        for (int i = 1; i <= Const; i++) {
            executor.execute(new Runner(i));
        }

        executor.shutdown();
    }
}
