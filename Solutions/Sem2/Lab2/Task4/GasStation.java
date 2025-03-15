package org2.lab4;


class GasStation {
    private int availablePumps; // Количество доступных колонок

    public GasStation(int pumpCount) {
        this.availablePumps = pumpCount; // Инициализация колонок
    }

    // Метод для заправки машины
    public synchronized void refuel(String carName) {
        while (availablePumps == 0) { // Если все колонки заняты, ждем
            try {
                System.out.println(carName + " ждет свободной колонки...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(carName + " прерван во время ожидания.");
            }
        }

        availablePumps--; // если колонка становится доступной, то ее занимают
        System.out.println(carName + " начала заправку. Доступно колонок: " + availablePumps);

        try {
            Thread.sleep(2000); // Имитация времени заправки
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(carName + " прерван во время заправки.");
        }

        availablePumps++; // Освободили колонку
        System.out.println(carName + " завершила заправку. Доступно колонок: " + availablePumps);

        notifyAll(); // Уведомляем другие потоки, что колонка свободна
    }
}