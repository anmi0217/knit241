package org.knit.solutions.ClassesSem2.lab4.task1;

public class EmailNotifier implements StockObserver {
    @Override
    public void update(String name, double price, double volume) {
        System.out.println("EmailNotifier: Акция " + name + " Цена: " + price  + "$; Объём: " + volume);
    }
}
