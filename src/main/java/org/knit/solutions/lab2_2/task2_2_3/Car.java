package org.knit.solutions.lab2_2.task2_2_3;

class Car implements Runnable {
    private final RailwayCrossing crossing;

    public Car(RailwayCrossing crossing) {
        this.crossing = crossing;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " едет к переезду.");
                Thread.sleep(1500);

                crossing.waitForTrain();

                System.out.println(Thread.currentThread().getName() + " проезжает переезд.");
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}