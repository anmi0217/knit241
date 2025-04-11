package org.knit.Solutions.Task7;

public class Warehouse {
    private int items = 0;
    private final int MAX_ITEMS = 5;

    public synchronized void work() {
        while (items >= MAX_ITEMS) {
            try {
                System.out.println("Производитель ждет, пока потребитель заберет товар...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        items++;
        System.out.println("Производитель сделал предмет. Предметов на складе: " + items);
        notify();
    }

    public synchronized void issuance() {
        while (items == 0) {
            try {
                System.out.println("Потребитель ждет, пока появятся товары...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        items--;
        System.out.println("Потребитель забрал товар. Товаров на складе: " + items);
        notify();
    }
}
