package org.knit.solutions.ClassesSem2.lab4.task1;

// Интерфейс подписчика
interface StockObserver  {
    void update(String name, double price, double volume);
}
