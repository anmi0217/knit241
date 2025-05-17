/*
2.9 Задача «Конвейер сборки деталей»

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

package org2.lab9;

import org2.annotations.Discription;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Discription(value = 9, name = "Конвейер сборки деталей")
public class Task9 {
    public static void main(String[] args) {
        // Очереди для передачи деталей между рабочими
        BlockingQueue<Part> stampToAssemblyQueue = new LinkedBlockingQueue<>(5); // Ограничение на 5 заготовок
        BlockingQueue<Part> assemblyToQualityQueue = new LinkedBlockingQueue<>(5); // Ограничение на 5 готовых деталей
        BlockingQueue<Part> warehouse = new LinkedBlockingQueue<>(10); // Ограничение на 10 деталей на складе

        // Создаем и запускаем потоки для рабочих
        Thread stampWorkerThread = new Thread(new StampWorker(stampToAssemblyQueue));
        Thread assemblyWorkerThread = new Thread(new AssemblyWorker(stampToAssemblyQueue, assemblyToQualityQueue));
        Thread qualityControlWorkerThread = new Thread(new QualityControlWorker(assemblyToQualityQueue, warehouse));

        stampWorkerThread.start();
        assemblyWorkerThread.start();
        qualityControlWorkerThread.start();

        try {
            stampWorkerThread.join();
            assemblyWorkerThread.join();
            qualityControlWorkerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван.");
        }

        System.out.println("Работа завершена.");
    }
}
