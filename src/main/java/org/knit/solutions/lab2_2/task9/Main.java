//2.9 Задача «Конвейер сборки деталей»
//        Описание задачи
//        На заводе работают три типа рабочих, каждый из которых выполняет свою часть работы в конвейерном режиме:
//
//        Штамповщик – вырезает заготовку (создает объект детали).
//        Сборщик – собирает из заготовки готовую деталь.
//        Оператор контроля качества – проверяет деталь и отправляет на склад.
//        Каждый рабочий – отдельный поток, и они должны работать последовательно, используя общую очередь для передачи деталей.
package org.knit.lab2_2.task9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.knit.tasks_description;

@tasks_description(number = 9, name = "Конвейер сборки деталей")
public class Main {
    public static final String POISON_PILL = "POISON_PILL";

    public static void main(String[] args) {

        BlockingQueue<String> stampingQueue   = new ArrayBlockingQueue<>(5);
        BlockingQueue<String> assemblingQueue = new ArrayBlockingQueue<>(5);
        BlockingQueue<String> warehouseQueue  = new ArrayBlockingQueue<>(5);

        Thread stampingWorker  = new Thread(new StampingWorker(stampingQueue), "Штамповщик");
        Thread assemblingWorker = new Thread(new AssemblingWorker(stampingQueue, assemblingQueue), "Сборщик");
        Thread qualityWorker   = new Thread(new QualityWorker(assemblingQueue, warehouseQueue), "Оператор контроля");
        Thread shipmentWorker  = new Thread(new ShipmentWorker(warehouseQueue), "Грузчик");

        stampingWorker.start();
        assemblingWorker.start();
        qualityWorker.start();
        shipmentWorker.start();
    }
}
