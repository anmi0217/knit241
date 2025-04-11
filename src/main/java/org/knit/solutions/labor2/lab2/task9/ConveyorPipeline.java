package org.knit.solutions.labor2.lab2.task9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConveyorPipeline {

    public static void main(String[] args) {
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

