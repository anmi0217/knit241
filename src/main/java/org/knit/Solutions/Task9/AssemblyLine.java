package org.knit.Solutions.Task9;

import java.util.concurrent.*;

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
 */

import org.knit.Solutions.TasksDescripton;

@TasksDescripton(number = 9, name = "2.9 Задача «Конвейер сборки деталей»")

public class AssemblyLine {
    private static final int MAX_STORAGE = 5;
    private static final BlockingQueue<Part> stampingQueue = new LinkedBlockingQueue<>();
    private static final BlockingQueue<Part> assemblingQueue = new LinkedBlockingQueue<>();
    private static final BlockingQueue<Part> storage = new LinkedBlockingQueue<>(MAX_STORAGE);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Штамповщик
        executor.execute(() -> {
            int id = 1;
            int count = (int) (Math.random() * 30);
            System.out.println("План штамповщика: " + count + " деталей");
            for (int i = 0; i < count; i++) {
                try {
                    Thread.sleep((long) (Math.random() * 4000));
                    Part part = new Part(id++);
                    System.out.println("Штамповщик: Заготовка " + part.getId() + " создана");
                    stampingQueue.put(part);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println("Штамповщик завершил работу.");
        });

        // Сборщик
        executor.execute(() -> {
            int processedParts = 0;
            while (processedParts < Math.random() * 10) {
                try {
                    Part part = stampingQueue.take();
                    Thread.sleep((long) (Math.random() * 2000)); // Случайная задержка
                    System.out.println("Сборщик: Заготовка " + part.getId() + " обработана");
                    assemblingQueue.put(part);
                    processedParts++;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println("Сборщик устал и уходит.");
        });

        // Оператор контроля
        executor.execute(() -> {
            while (true) {
                try {
                    Part part = assemblingQueue.take();
                    Thread.sleep((long) (Math.random() * 1000));
                    if (part.isDefective()) {
                        System.out.println("Оператор контроля: Деталь " + part.getId() + " бракована и отправлена на доработку");
                        stampingQueue.put(new Part(part.getId()));
                    } else {
                        storage.put(part); // Ждет, если склад заполнен
                        System.out.println("Оператор контроля: Деталь " + part.getId() + " проверена и отправлена на склад");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }
}
