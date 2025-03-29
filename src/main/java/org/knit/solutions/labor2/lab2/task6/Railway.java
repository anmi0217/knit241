package org.knit.solutions.labor2.lab2.task6;

public class Railway {
    private boolean isClosed = false;

    public synchronized void trainIsPassing() {
        System.out.println("Поезд едет, шлагбаум закрывается.");
        isClosed = true;
    }

    public synchronized void trainPassed() {
        System.out.println("Поезд проехал, шлагбаум открывается.");
        isClosed = false;
        notifyAll();
    }

    public synchronized void passCar(String carName) {
        while (isClosed) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(carName + " проехала переезд");

    }
    public static void main(String[] args) {

        Railway railway = new Railway();
        Thread train = new Thread(() -> {
            try {
                Thread.sleep(2000);
                railway.trainIsPassing();
                Thread.sleep(2000);
                railway.trainPassed();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread cars = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(450);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                railway.passCar(i + " машина");
            }
        });
        cars.start();
        train.start();
    }
}
