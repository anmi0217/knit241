package org.knit.solutions.lab4.task1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Издатель котировок — хранит данные по акциям и рассылает уведомления
 */
public class Stock {
    private final List<StockObserver> subscribers = new CopyOnWriteArrayList<>();
    private String ticker;
    private double price;
    private double volume;

    public void subscribe(StockObserver observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(StockObserver observer) {
        subscribers.remove(observer);
    }

    public void updatePrice(String tickerSymbol, double newPrice, double newVolume) {
        this.ticker = tickerSymbol;
        this.price = newPrice;
        this.volume = newVolume;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (StockObserver observer : subscribers) {
            observer.update(ticker, price, volume);
        }
    }
}
