package org.knit.solutions.lab2_4.Task2_11Classes;

public class MobileApp implements StockObserver {

    @Override
    public void update(String companyName, double price) {
        System.out.println("Новое уведомление на телефоне. Акции компании " + companyName + " теперь стоят " +
                price + "$");
    }
}
