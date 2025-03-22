package org.knit.solutions.lab2_4.Task2_11Classes;

public class EmailNotifier implements StockObserver {
    @Override
    public void update(String companyName, double price) {
        System.out.println("На email поступило сообщение! Акции компании " + companyName + " теперь стоят " +
                price + "$");
    }
}
