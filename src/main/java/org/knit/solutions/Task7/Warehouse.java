package org.labs.Tasks2.Task7;

public class Warehouse {
    private int itemCount = 0;

    public synchronized void produce(String producerName) throws InterruptedException {

        int MAX_ITEMS = 5;
        while (itemCount == MAX_ITEMS) {
            System.out.println(producerName + ": склад заполнен, жду...");
            wait();
        }

        itemCount++;
        System.out.println(producerName + " произвел товар. Товаров на складе: " + itemCount);

        notify();
    }

    public synchronized void consume(String consumerName) throws InterruptedException {
        while (itemCount == 0) {
            System.out.println(consumerName + ": склад пуст, жду...");
            wait();
        }

        itemCount--;
        System.out.println(consumerName + " забрал товар. Товаров на складе осталось: " + itemCount);

        notify();
    }
}
