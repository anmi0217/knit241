package org.knit.solutions.task33;

public class Task33 {
    public static void main(String[] args) {
        Crossroad crossroad = new Crossroad();
        Thread trafficLightThread = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                crossroad.trafficLight();
            }
        });
        trafficLightThread.start();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread carThread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    crossroad.car(finalI);
                }
            });
            carThread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
