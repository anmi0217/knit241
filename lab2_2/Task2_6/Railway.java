package org.dina.lab2_2.Task2_6;

/* 2.6 Задача «Железнодорожный переезд» 🚆🚗
📌 Описание:
Есть автомобили и поезд.

Если поезд приближается, машины останавливаются и ждут.
После того, как поезд проедет, машины продолжают движение.
🔹 Что нужно реализовать?
✔ Поток "Поезд" останавливает автомобили (wait()).
✔ Поток "Поезд" сообщает о завершении (notifyAll()).
✔ Машины ждут, если поезд едет, и продолжают движение после notifyAll(). */

public class Railway {
    private volatile boolean isClosed = false;

    public synchronized void trainIsPassing() {
        System.out.println("Поезд приближается, шлагбаум закрывается.");
        isClosed = true;
    }

    public synchronized void trainPassed() {
        System.out.println("Поезд отдаляется, шлагбаум открывается.");
        isClosed = false;
        notifyAll();
    }

    public synchronized void passCar(String carName) {
        while (isClosed) {
            try {
                System.out.println(carName + " ждет, пока поезд проедет...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(carName + " проехала переезд");
    }
}


