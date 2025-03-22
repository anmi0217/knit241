package org.knit.solutions.lab2_4.Task2_11Classes;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private final String companyName;
    private double currentPrice;
    private List<StockObserver> observers = new ArrayList<>();

    public Stock(String companyName, double currentPrice) {
        this.companyName = companyName;
        this.currentPrice = currentPrice;
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void setCurrentPrice(double newPrice) {
        currentPrice = newPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(companyName, currentPrice);
        }
    }
}
