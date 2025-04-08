package org.knit.solutions.Task9;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Conveyor {
    private final BlockingQueue<String> rawPartsQueue = new LinkedBlockingQueue<>(10);
    private final BlockingQueue<String> finishedPartsQueue = new LinkedBlockingQueue<>(10);
    private final BlockingQueue<String> warehouse = new LinkedBlockingQueue<>(5);

    public BlockingQueue<String> getRawPartsQueue() {
        return rawPartsQueue;
    }

    public BlockingQueue<String> getFinishedPartsQueue() {
        return finishedPartsQueue;
    }

    public BlockingQueue<String> getWarehouse() {
        return warehouse;
    }
}


