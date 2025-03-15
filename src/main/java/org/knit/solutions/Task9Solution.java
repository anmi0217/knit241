package org.knit.solutions;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.knit.TaskDescription;
import org.knit.solutions.Task9.StampingWorker;
import org.knit.solutions.Task9.AssemblingWorker;
import org.knit.solutions.Task9.QualityWorker;
import org.knit.solutions.Task9.ShipmentWorker;

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

        System.out.println("Задача 9 запущена");

        final String POISON_PILL = "POISON_PILL";

        BlockingQueue<String> stampingQueue   = new ArrayBlockingQueue<>(5);
        BlockingQueue<String> assemblingQueue = new ArrayBlockingQueue<>(5);
        BlockingQueue<String> warehouseQueue  = new ArrayBlockingQueue<>(5);

        Thread stampingWorker   = new Thread(new StampingWorker(stampingQueue, POISON_PILL),
                "Штамповщик");
        Thread assemblingWorker = new Thread(new AssemblingWorker(stampingQueue, assemblingQueue, POISON_PILL),
                "Сборщик");
        Thread qualityWorker    = new Thread(new QualityWorker(assemblingQueue, warehouseQueue, POISON_PILL),
                "Оператор контроля");
        Thread shipmentWorker   = new Thread(new ShipmentWorker(warehouseQueue, POISON_PILL),
                "Грузчик");

        stampingWorker.start();
        assemblingWorker.start();
        qualityWorker.start();
        shipmentWorker.start();
    }
}
