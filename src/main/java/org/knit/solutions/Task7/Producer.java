package org.labs.Tasks2.Task7;

public class Producer extends Thread {
    private final Warehouse warehouse;
    private final String producerName;

    public Producer(String producerName, Warehouse warehouse) {
        this.producerName = producerName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                warehouse.produce(producerName);
                Thread.sleep((long) (Math.random() * 1000 + 500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(producerName + " был прерван во время производства.");
        }
        System.out.println(producerName + " закончил работу.");
    }
}

