package org2.lab8;


class TrafficLight {
    private boolean isGreen = false; // Состояние светофора (зеленый/красный)

    // Метод для машин (ожидание или движение)
    public synchronized void drive(String carName) throws InterruptedException {
        while (!isGreen) { // Если красный свет, машины ждут
            System.out.println(carName + " ждет на красный свет.");
            wait();
        }

        System.out.println(carName + " едет на зеленый свет.");
        Thread.sleep(500); // Имитация времени проезда
    }

    // Метод для светофора (переключение цвета)
    public synchronized void switchLight() throws InterruptedException {
        while (true) { // Бесконечный цикл переключения светофора
            isGreen = !isGreen; // Переключаем свет
            if (isGreen) {
                System.out.println("Светофор: зеленый свет. Машины могут ехать!");
                notifyAll(); // Уведомляем все машины, что можно ехать
            } else {
                System.out.println("Светофор: красный свет. Машины останавливаются.");
            }

            Thread.sleep(5000); // Имитация времени работы светофора (5 секунд)
        }
    }
}
