package org.knit.solutions.lab2_4.task2_4_1;

class EmailNotifier implements StockObserver {
    @Override
    public void update(float price) {
        System.out.println("EmailNotifier: Цена: " + price);
    }
}
