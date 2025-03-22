package org.knit.solutions;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_2.task2_9.Part;

/*
Описание задачи
На заводе работают три типа рабочих, каждый из которых выполняет свою часть работы в конвейерном режиме:

Штамповщик – вырезает заготовку (создает объект детали).
Сборщик – собирает из заготовки готовую деталь.
Оператор контроля качества – проверяет деталь и отправляет на склад.
Каждый рабочий – отдельный поток, и они должны работать последовательно, используя общую очередь для передачи деталей.

Требования к решению
Использовать потоки (Thread или ExecutorService).
Использовать синхронизацию (wait(), notify(), BlockingQueue).
Реализовать конвейерную передачу данных между потоками.

Подсказки к решению
Использовать BlockingQueue для передачи деталей между рабочими.
Штамповщик передает заготовку сборщику, а тот – оператору контроля.
Потоки должны ждать, если предыдущий этап не завершен.

Дополнительные идеи
Добавить случайные задержки в работе потоков (Thread.sleep()) для имитации времени обработки.
Ограничить размер склада (например, если на складе уже 5 деталей, оператор контроля ждет, пока не освободится место).
Реализовать обработку брака – если деталь не соответствует стандарту, она отправляется на доработку.
 */
@TaskDescription(taskNumber = 9, taskDescription = "Конвейер сборки деталей")

public class Task9Solution implements Solution {
    @Override
    public void execute() {
        final int PARTS_COUNT = 10; // Количество деталей для обработки

        // Очереди для передачи деталей между рабочими:
        // Первая очередь: от Штамповщика к Сборщику.
        BlockingQueue<Part> queue1 = new ArrayBlockingQueue<>(1);
        // Вторая очередь: от Сборщика к Оператору контроля.
        BlockingQueue<Part> queue2 = new ArrayBlockingQueue<>(1);

        // Создаем пул из трех потоков
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Штамповщик: создает заготовки и помещает их в очередь для Сборщика.
        executor.execute(() -> {
            try {
                for (int i = 1; i <= PARTS_COUNT; i++) {
                    Part part = new Part(i);
                    System.out.println("Штамповщик: Заготовка " + part.getId() + " создана");
                    queue1.put(part); // Если очередь заполнена, поток ждет
                    // Симуляция времени на создание заготовки
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Сборщик: получает заготовку из первой очереди, обрабатывает её и передает Оператору контроля.
        executor.execute(() -> {
            try {
                for (int i = 1; i <= PARTS_COUNT; i++) {
                    Part part = queue1.take(); // Ждем появления заготовки
                    System.out.println("Сборщик: Заготовка " + part.getId() + " обработана");
                    // Симуляция времени на сборку детали
                    Thread.sleep(500);
                    queue2.put(part);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Оператор контроля: получает деталь из второй очереди, проверяет и отправляет на склад.
        executor.execute(() -> {
            try {
                for (int i = 1; i <= PARTS_COUNT; i++) {
                    Part part = queue2.take(); // Ждем появления детали
                    System.out.println("Оператор контроля: Деталь " + part.getId() + " проверена и отправлена на склад");
                    // Симуляция времени на контроль качества
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Завершаем работу ExecutorService после выполнения всех задач
        executor.shutdown();
    }
}


