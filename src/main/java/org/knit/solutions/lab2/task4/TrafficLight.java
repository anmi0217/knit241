package org.knit.solutions.lab2.task4;

public class TrafficLight {
    private boolean greenSignal = true;

    // Переключение состояния сигнала
    public synchronized void toggle() {
        greenSignal = !greenSignal;

        if (greenSignal) {
            System.out.println("Светофор: зелёный. Движение разрешено.");
        } else {
            System.out.println("Светофор: красный. Движение запрещено.");
        }

        notifyAll();
    }

    // Машина пытается проехать перекрёсток
    public synchronized void approach(String vehicleName) {
        while (!greenSignal) {
            System.out.println(vehicleName + " ждёт на красный.");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(vehicleName + " пересекла перекрёсток.");
    }
}
