package org.knit.tasks.task31;

public class Task31 {
    public static void main(String[] args) {
        RailwayCrossing railwayCrossing = new RailwayCrossing();
        Thread trainThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                railwayCrossing.train();
            }
        });
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Thread carThread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    railwayCrossing.car(finalI);
                }
            });
            carThread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        trainThread.start();
    }
}
