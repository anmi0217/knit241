package org.labs.Tasks2.Task8;

public class TrafficLight extends Thread {
    private final Object lock;
    private boolean isGreen = false;

    public TrafficLight(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    isGreen = !isGreen;
                    String currentColor = isGreen ? "ЗЕЛЕНЫЙ" : "КРАСНЫЙ";
                    System.out.println("[СВЕТОФОР] Переключился на " + currentColor);

                    lock.notifyAll();
                }
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("[СВЕТОФОР] Прерван. Остановка.");
            Thread.currentThread().interrupt();
        }
    }

    public boolean isGreenLight() {
        return isGreen;
    }
}
