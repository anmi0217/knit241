package org.knit.solutions.org2.lab6;

class RailwayCrossing {
    private boolean isTrainComing = false; // Флаг, указывающий, приближается ли поезд

    // Метод для автомобилей
    public synchronized void carCrossing(String carName) throws InterruptedException {
        while (isTrainComing) { // Если поезд приближается, автомобили ждут
            System.out.println(carName + " ждет, так как поезд приближается...");
            wait();
        }

        System.out.println(carName + " проезжает переезд.");
        Thread.sleep(500); // Имитация времени проезда автомобиля
    }

    // Метод для поезда
    public synchronized void trainCrossing() throws InterruptedException {
        isTrainComing = true; // Поезд приближается
        System.out.println("Поезд приближается! Автомобили останавливаются.");

        Thread.sleep(3000); // Имитация времени проезда поезда

        isTrainComing = false; // Поезд проехал
        System.out.println("Поезд проехал. Автомобили могут продолжать движение.");
        notifyAll(); // Уведомляем все автомобили, что можно ехать
    }
}
