package org2.lab7;

class Consumer implements Runnable {
    private final Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) { // Потребитель забирает 10 товаров
                warehouse.consume();
                Thread.sleep(1000); // Имитация времени потребления товара
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Потребитель прерван.");
        }
    }
}
