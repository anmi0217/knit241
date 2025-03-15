package org.knit.solutions.lab2_4.task2_4_1;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private float price;
    private List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(price);
            System.out.println("Цена изменилась до " + price);
        }
    }
}
