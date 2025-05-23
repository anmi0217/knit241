package org.knit.solutions.lab2.task3;

public class RailwayCrossing {
    private boolean trainComing = false; // Флаг: поезд на переезде

    // Метод вызывается поездом
    public synchronized void arriveTrain() {
        System.out.println("[Переезд] Поезд приближается! Шлагбаум опускается...");
        trainComing = true;

        try {
            Thread.sleep(7000); // поезд "едет"
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        trainComing = false;
        System.out.println("[Переезд] Поезд проехал. Шлагбаум поднят, путь свободен.");
        notifyAll(); // пропускаем машины
    }

    // Метод вызывается машинами
    public synchronized void passCar(String carName) {
        while (trainComing) {
            try {
                System.out.println("[Ожидание] " + carName + " ждёт: переезд закрыт.");
                wait(); // ждем, пока поезд проедет
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("[Движение] " + carName + " проехала через переезд.");
    }
}
