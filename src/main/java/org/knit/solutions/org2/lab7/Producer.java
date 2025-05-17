package org.knit.solutions.org2.lab7;

class Producer implements Runnable {
    private final Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) { // Производитель создает 10 товаров
                warehouse.produce(i);
                Thread.sleep(500); // Имитация времени создания товара
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Производитель прерван.");
        }
    }
}
