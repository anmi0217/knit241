package org.knit.solutions.org2.lab11;

// Интерфейс наблюдателя
interface StockObserver {
    void update(String stockName, double price); // Метод для получения уведомлений
}
