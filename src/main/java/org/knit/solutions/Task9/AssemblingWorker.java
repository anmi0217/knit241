package org.labs.Tasks2.Task9;

import java.util.concurrent.BlockingQueue;

public class AssemblingWorker implements Runnable {
    private final BlockingQueue<String> stampingQueue;
    private final BlockingQueue<String> assemblingQueue;

    public AssemblingWorker(BlockingQueue<String> stampingQueue,
                            BlockingQueue<String> assemblingQueue) {
        this.stampingQueue = stampingQueue;
        this.assemblingQueue = assemblingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String blank = stampingQueue.take();

                if (Main.POISON_PILL.equals(blank)) {
                    assemblingQueue.put(Main.POISON_PILL);
                    System.out.println(Thread.currentThread().getName() + ": получил сигнал завершения, передал дальше.");
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
