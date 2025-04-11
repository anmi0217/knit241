package org.dina.lab2_2.Task2_8;

/* 2.8 Задача «Перекресток: светофор и машины» 🚦🚗
📌 Описание:
На перекрестке светофор управляет движением:

Красный свет – машины стоят (wait()).
Зеленый свет – машины едут (notifyAll()).
Светофор переключается каждые 5 секунд.
🔹 Что нужно реализовать?
✔ Поток "Светофор" изменяет цвет и отправляет notifyAll().
✔ Потоки "Машина" ждут wait(), если красный свет. */

public class TrafficLight {
    private boolean isRed = true;
    private int cyclesCompleted = 0;
    private final int MAX_CYCLES = 5; // Максимальное количество циклов светофора

    public synchronized boolean isRed() {
        return isRed;
    }

    public synchronized void waitForGreen() {
        while (isRed) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public synchronized boolean changeColor() {
        isRed = !isRed;
        System.out.println((isRed ? "Красный" : "Зеленый") + " свет включен.");
        notifyAll();
        cyclesCompleted++;
        return cyclesCompleted < MAX_CYCLES;
    }
}
