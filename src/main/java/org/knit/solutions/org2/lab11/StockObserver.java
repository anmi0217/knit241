package org.knit.solutions.org2.lab11;

// Интерфейс наблюдателя
// 1. Объявите интерфейс (если его нет)
interface StockObserver {
    void update(String stockName, double price);
}
