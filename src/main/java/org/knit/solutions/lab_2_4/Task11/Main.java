package org.knit.solutions.lab_2_4.Task11;

public class Main {
    public static void main(String[] args) {
        Stock teslaStock = new Stock("Tesla", 100);

        StockObserver mobileApp1 = new MobileApp();
        StockObserver emailNotifier1 = new EmailNotifier();

        teslaStock.addObserver(mobileApp1);
        teslaStock.addObserver(emailNotifier1);

        teslaStock.setCurrentPrice(120);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        teslaStock.setCurrentPrice(110);
    }
}