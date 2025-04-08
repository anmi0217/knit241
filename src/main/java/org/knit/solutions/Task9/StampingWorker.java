package org.knit.solutions.Task9;


import java.util.concurrent.ThreadLocalRandom;

public class StampingWorker extends Thread {
    private final Conveyor conveyor;
    private int partNumber = 1;

    public StampingWorker(Conveyor conveyor) {
        this.conveyor = conveyor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String part = "Заготовка " + partNumber++;
                System.out.println("Штамповщик: " + part + " создана");
                conveyor.getRawPartsQueue().put(part);
                Thread.sleep(ThreadLocalRandom.current().nextInt(1500, 5000)); // Случайная задержка
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Штамповщик остановлен.");
        }
    }
}


