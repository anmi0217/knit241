package org.labs.Tasks2.Task10;

import java.util.concurrent.*;

public class Runner implements Runnable {
    private final String name;
    private final CyclicBarrier startBarrier;
    private final CyclicBarrier finishBarrier;

    public Runner(String name, CyclicBarrier startBarrier, CyclicBarrier finishBarrier) {
        this.name = name;
        this.startBarrier = startBarrier;
        this.finishBarrier = finishBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " готов к старту.");
            startBarrier.await();

            System.out.println(name + " начал забег!");
            int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
            long endTime = System.currentTimeMillis() + runTime;
            while (System.currentTimeMillis() < endTime) {
                if (RunnerRace.raceInterrupted.get()) {
                    System.out.println(name + " прекращает забег, так как гонка прервана.");
                    return;
                }
                Thread.sleep(100);
            }

            if (RunnerRace.raceInterrupted.get()) {
                System.out.println(name + " завершается после бега, так как гонка прервана.");
                return;
            }

            if (ThreadLocalRandom.current().nextInt(1, 101) <= 20) {
                if (RunnerRace.raceInterrupted.compareAndSet(false, true)) {
                    System.out.println(name + " получил травму и не может продолжить!");
                    finishBarrier.reset();
                }
            } else {
                System.out.println(name + " финишировал за " + runTime + " мс.");
                try {
                    finishBarrier.await();
                } catch (BrokenBarrierException ex) {
                    System.out.println(name + " не смог дождаться финиша из-за прерывания гонки.");
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван.");
        } catch (BrokenBarrierException e) {
            System.out.println(name + " не смог дождаться финиша из-за прерывания гонки.");
        }
    }
}
