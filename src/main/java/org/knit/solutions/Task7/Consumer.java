package org.labs.Tasks2.Task7;

public class Consumer extends Thread {
    private final Warehouse warehouse;
    private final String consumerName;

    public Consumer(String consumerName, Warehouse warehouse) {
        this.consumerName = consumerName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                warehouse.consume(consumerName);
                Thread.sleep((long) (Math.random() * 1000 + 500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(consumerName + " был прерван во время потребления.");
        }
        System.out.println(consumerName + " закончил работу.");
    }
}

