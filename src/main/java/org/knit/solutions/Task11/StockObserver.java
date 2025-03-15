package org.knit.solutions.Task11;

interface StockObserver {
    void update(Stock stock, double oldPrice, double newPrice);
}