package org.knit.solutions.lab_2_4.Task11;

public class MobileApp implements StockObserver {
    @Override
    public void notifyAboutPriceChange(String name, double oldPrice, double newPrice) {
        System.out.println("Уведомление в мобильном приложении:\n Цена на акцию " + name + " изменилась с " + oldPrice + " до " + newPrice);
    }
}
