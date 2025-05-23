package org.knit.solutions.lab4.task1;

public class EmailNotifier implements StockObserver {

    @Override
    public void update(String stockName, double currentPrice, double tradeVolume) {
        System.out.println("[Email] Обновление по акции: " + stockName +
                " | Цена: " + currentPrice + " USD, Объём: " + tradeVolume);
    }
}