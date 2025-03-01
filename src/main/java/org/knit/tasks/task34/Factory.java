package org.knit.tasks.task34;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Factory {
    public static void makeDetails(int detailsNumber) {
        BlockingQueue<Detail> workpiecesQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> detailsQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> storageQueue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Stamper(detailsNumber, workpiecesQueue));
        executorService.submit(new Assembler(detailsNumber, workpiecesQueue, detailsQueue));
        executorService.submit(new Operator(detailsNumber, detailsQueue, storageQueue));
        executorService.shutdown();
    }
}
