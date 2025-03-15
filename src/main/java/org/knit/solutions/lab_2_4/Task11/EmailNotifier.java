package org.knit.solutions.lab_2_4.Task11;

public class EmailNotifier implements StockObserver {
    @Override
    public void notifyAboutPriceChange(String name, double oldPrice, double newPrice) {
        System.out.println("Электронное письмо:\n Цена на акцию " + name + " изменилась с " + oldPrice + " до " + newPrice);
    }
}
