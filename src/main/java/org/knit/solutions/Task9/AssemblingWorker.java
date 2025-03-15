package org.knit.solutions.Task9;

import java.util.concurrent.BlockingQueue;

public class AssemblingWorker implements Runnable {
    private final BlockingQueue<String> stampingQueue;
    private final BlockingQueue<String> assemblingQueue;
    private final String poisonPill;

    public AssemblingWorker(BlockingQueue<String> stampingQueue,
                            BlockingQueue<String> assemblingQueue,
                            String poisonPill) {
        this.stampingQueue = stampingQueue;
        this.assemblingQueue = assemblingQueue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String blank = stampingQueue.take();

                if (poisonPill.equals(blank)) {
                    assemblingQueue.put(poisonPill);
                    System.out.println(Thread.currentThread().getName()
                            + ": получил сигнал завершения, передал дальше.");
                    break;
                }

                assembleDetail(blank);

                Thread.sleep((long) (Math.random() * 1000 + 500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": был(а) прерван(а).");
        }

        System.out.println(Thread.currentThread().getName() + ": закончил(а) работу.");
    }

    private void assembleDetail(String blank) throws InterruptedException {
        String detail = blank.replace("Заготовка", "Деталь");
        assemblingQueue.put(detail);

        System.out.println(Thread.currentThread().getName() + ": "
                + blank + " обработана -> " + detail);
    }
}
