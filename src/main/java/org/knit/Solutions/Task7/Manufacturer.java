package org.knit.Solutions.Task7;

public class Manufacturer extends Thread{
    private final Warehouse warehouse;

    public Manufacturer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            warehouse.work();
        }
    }
}
