package org.knit.solutions.lab_2_4.Task11;

public interface StockObserver {
    void notifyAboutPriceChange(String name, double oldPrice, double newPrice);
}
