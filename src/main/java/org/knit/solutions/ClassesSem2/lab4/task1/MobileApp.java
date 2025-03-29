package org.knit.solutions.ClassesSem2.lab4.task1;

public class MobileApp implements StockObserver {
    @Override
    public void update(String name, double price, double volume) {
        System.out.println("Phone Display: Акция " + name + " Цена: " + price  + "$; Объём: " + volume);

    }
}
