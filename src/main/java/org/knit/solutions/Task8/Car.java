package org.labs.Tasks2.Task8;

public class Car extends Thread {
    private final Object lock;
    private final TrafficLight trafficLight;
    private final String carName;

    public Car(String carName, TrafficLight trafficLight, Object lock) {
        this.carName = carName;
        this.trafficLight = trafficLight;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                driveToIntersection(i);
            }
            System.out.println(carName + " завершил(а) все поездки.");
        } catch (InterruptedException e) {
            System.out.println(carName + " прерван(а). Остановка.");
            Thread.currentThread().interrupt();
        }
    }

    private void driveToIntersection(int attempt) throws InterruptedException {
        Thread.sleep((long) (Math.random() * 4000 + 1000));

        synchronized (lock) {
            while (!trafficLight.isGreenLight()) {
                System.out.println(carName + " ждет (красный) попытка #" + attempt);
                lock.wait();
            }
            System.out.println(carName + " проезжает перекресток (попытка #" + attempt + ")...");
        }

        Thread.sleep(1000);
        System.out.println(carName + " проехал(а) перекресток (попытка #" + attempt + ").");
    }
}

