package org.knit.Solutions.Task8;

class TrafficLight {
    private boolean isGreen = false;

    public synchronized void waitForGreen(String carName) {
        while (!isGreen) {
            try {
                System.out.println(carName + " остановилась на красный свет...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(carName + " проехала перекресток!");
    }

    public synchronized void switchLight() {
        isGreen = !isGreen;
        System.out.println("Светофор переключился: " + (isGreen ? "Зеленый! Машины могут ехать." : "Красный! Машины должны остановиться."));
        notifyAll();
    }
}
