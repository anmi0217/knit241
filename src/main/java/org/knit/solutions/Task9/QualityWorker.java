package org.labs.Tasks2.Task9;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class QualityWorker implements Runnable {
    private final BlockingQueue<String> assemblingQueue;
    private final BlockingQueue<String> warehouseQueue;
    private final Random random = new Random();
    private int checkedCount = 0;

    public QualityWorker(BlockingQueue<String> assemblingQueue,
                         BlockingQueue<String> warehouseQueue) {
        this.assemblingQueue = assemblingQueue;
        this.warehouseQueue = warehouseQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String detail = assemblingQueue.take();

                if (Main.POISON_PILL.equals(detail)) {
                    warehouseQueue.put(Main.POISON_PILL);
                    System.out.println(Thread.currentThread().getName()
                            + ": получил сигнал завершения, передал дальше.");
                    break;
                }

                checkDetail(detail);

                Thread.sleep((long) (Math.random() * 1000 + 500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": был(а) прерван(а).");
        }

        System.out.println(Thread.currentThread().getName() + ": закончил(а) работу.");
    }

    private void checkDetail(String detail) throws InterruptedException {
        checkedCount++;
        boolean isDefect = (random.nextInt(100) < 10);

        if (isDefect) {
            System.out.println(Thread.currentThread().getName()
                    + ": " + detail + " признана бракованной, отправляем на доработку.");

            assemblingQueue.put(detail + " (переделанная)");
        } else {
            warehouseQueue.put(detail);
            System.out.println(Thread.currentThread().getName()
                    + ": " + detail + " проверена и отправлена на склад. Всего проверено: " + checkedCount);
        }
    }
}
