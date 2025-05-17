package org.knit.solutions.org2.lab6;

class Car implements Runnable {
    private final RailwayCrossing crossing;
    private final String name;

    public Car(RailwayCrossing crossing, String name) {
        this.crossing = crossing;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) { // Автомобили постоянно пытаются проехать
                crossing.carCrossing(name);
                Thread.sleep(1000); // Имитация времени между попытками проезда
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " прерван.");
        }
    }
}