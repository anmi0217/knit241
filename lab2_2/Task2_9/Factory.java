package org.dina.lab2_2.Task2_9;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/* 2.9 Задача «Конвейер сборки деталей»
Описание задачи
На заводе работают три типа рабочих, каждый из которых выполняет свою часть работы в конвейерном режиме:

Штамповщик – вырезает заготовку (создает объект детали).
Сборщик – собирает из заготовки готовую деталь.
Оператор контроля качества – проверяет деталь и отправляет на склад.
Каждый рабочий – отдельный поток, и они должны работать последовательно, используя общую очередь для передачи деталей.

Требования к решению
Использовать потоки (Thread или ExecutorService).
Использовать синхронизацию (wait(), notify(), BlockingQueue).
Реализовать конвейерную передачу данных между потоками. */

public class Factory {
    final private BlockingQueue<Detail> stampingQueue = new LinkedBlockingQueue<>();
    final private BlockingQueue<Detail> reassemblingQueue = new LinkedBlockingQueue<>();
    final private BlockingQueue<Detail> assemblingQueue = new LinkedBlockingQueue<>();
    final private BlockingQueue<Detail> warehouseQueue = new LinkedBlockingQueue<>();

    private Boolean isWorkFinished = false;

    public synchronized Boolean getWorkFinished() {
        return isWorkFinished;
    }

    public synchronized void setWorkFinished(Boolean workFinished) {
        isWorkFinished = workFinished;
    }

    public void initProduction() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new Stamper(stampingQueue));
        executorService.submit(new Assembler(stampingQueue, reassemblingQueue, assemblingQueue, this));
        executorService.submit(new Operator(stampingQueue, reassemblingQueue, assemblingQueue, warehouseQueue, this));

        executorService.shutdown();
    }
}
