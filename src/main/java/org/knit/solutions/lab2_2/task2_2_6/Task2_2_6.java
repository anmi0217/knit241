package org.knit.solutions.lab2_2.task2_2_6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Task2_2_6 {
    public static void Run() {
        BlockingQueue<Detail> stampingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> assemblingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> warehouseQueue = new LinkedBlockingQueue<>();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new Stamper(stampingQueue));
        executorService.submit(new Assembler(stampingQueue, assemblingQueue));
        executorService.submit(new Operator(assemblingQueue, warehouseQueue));

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        System.out.println("Все детали обработаны и отправлены на склад.");
    }
}
