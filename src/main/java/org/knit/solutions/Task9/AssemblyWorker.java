package org.knit.solutions.Task9;


import java.util.concurrent.ThreadLocalRandom;

public class AssemblyWorker extends Thread {
    private final Conveyor conveyor;

    public AssemblyWorker(Conveyor conveyor) {
        this.conveyor = conveyor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String rawPart = conveyor.getRawPartsQueue().take();
                System.out.println("Сборщик: " + rawPart + " обработана");

                if (ThreadLocalRandom.current().nextInt(100) < 20) { // 20% шанс брака
                    System.out.println("Сборщик: " + rawPart + " признана бракованной. Отправлена на доработку.");
                    continue;
                }

                String finishedPart = rawPart.replace("Заготовка", "Деталь");
                conveyor.getFinishedPartsQueue().put(finishedPart);
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000)); // Случайная задержка
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Сборщик остановлен.");
        }
    }
}


