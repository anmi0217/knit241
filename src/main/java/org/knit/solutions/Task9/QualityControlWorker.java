package org.knit.solutions.Task9;


import java.util.concurrent.ThreadLocalRandom;

public class QualityControlWorker extends Thread {
    private final Conveyor conveyor;

    public QualityControlWorker(Conveyor conveyor) {
        this.conveyor = conveyor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String finishedPart = conveyor.getFinishedPartsQueue().take();
                System.out.println("Оператор контроля: " + finishedPart + " проверена");

                if (conveyor.getWarehouse().remainingCapacity() == 0) {
                    System.out.println("Склад заполнен. Оператор контроля ждет.");
                }

                conveyor.getWarehouse().put(finishedPart);
                System.out.println("Оператор контроля: " + finishedPart + " отправлена на склад");
                Thread.sleep(ThreadLocalRandom.current().nextInt(1500, 2500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Оператор контроля остановлен.");
        }
    }
}


