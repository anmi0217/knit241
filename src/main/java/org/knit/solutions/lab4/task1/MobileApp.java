package org.knit.solutions.lab4.task1;

public class MobileApp implements StockObserver {

    @Override
    public void update(String stockName, double currentPrice, double tradeVolume) {
        System.out.println("[MobileApp] Отображение: " + stockName +
                " - Цена: " + currentPrice + " USD; Объём: " + tradeVolume);
    }
}
