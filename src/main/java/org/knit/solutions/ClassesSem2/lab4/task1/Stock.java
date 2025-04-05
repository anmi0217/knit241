package org.knit.solutions.ClassesSem2.lab4.task1;

import java.util.ArrayList;
import java.util.List;

// Издатель (Биржа)
public class Stock {
    private List<StockObserver> observers = new ArrayList<>();
    private String name;
    private double price;
    private double volume;

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void setPrice(String name, double price, double volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(name, price, volume);
        }
    }
}
