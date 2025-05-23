package org.knit.solutions.lab3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private final int number;
    private final CyclicBarrier readyBarrier;
    private final CyclicBarrier endBarrier;

    public Runner(int number, CyclicBarrier readyBarrier, CyclicBarrier endBarrier) {
        this.number = number;
        this.readyBarrier = readyBarrier;
        this.endBarrier = endBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Бегун #" + number + " занял позицию у линии старта.");
            readyBarrier.await();

            int delay = ThreadLocalRandom.current().nextInt(500, 6000);

            if (delay >= 5000) {
                System.out.println("Бегун #" + number + " получил травму. Сходит с дистанции.");
                endBarrier.await();
                return;
            }

            Thread.sleep(delay);
            System.out.printf("Бегун #%d прибежал за %.2f секунд%n", number, delay / 1000.0);

            endBarrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            System.err.println("Ошибка выполнения у бегуна #" + number);
        }
    }
}
