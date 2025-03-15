package org.knit.solutions.lab_2_4.Task11;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String name;
    private double currentPrice;
    private List<StockObserver> observers;

    public Stock(String name, double currentPrice) {
        this.name = name;
        this.currentPrice = currentPrice;
        observers = new ArrayList<>();
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double newCurrentPrice) {
        for (StockObserver observer : observers) {
            observer.notifyAboutPriceChange(name, currentPrice, newCurrentPrice);
        }
        this.currentPrice = newCurrentPrice;
    }

    public void addObserver(StockObserver newObserver) {
        observers.add(newObserver);
    }

    public void removeObserver(StockObserver oldObserver) {
        if (observers.contains(oldObserver)) {
            observers.remove(oldObserver);
        }
    }
}
