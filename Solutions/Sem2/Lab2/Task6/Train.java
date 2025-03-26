package org2.lab6;

class Train implements Runnable {
    private final RailwayCrossing crossing;

    public Train(RailwayCrossing crossing) {
        this.crossing = crossing;
    }

    @Override
    public void run() {
        try {
            while (true) { // Поезд периодически проезжает
                crossing.trainCrossing();
                Thread.sleep(10000); // Имитация интервала между поездами
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Поезд прерван.");
        }
    }
}
