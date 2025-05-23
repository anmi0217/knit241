package org.knit.solutions.lab4.task1;

// Интерфейс для подписоты
public interface StockObserver {
    void update(String stockName, double currentPrice, double tradeVolume);
}
