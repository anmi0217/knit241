package org.knit.solutions.task36;

import java.util.ArrayList;
import java.util.List;

public class Stock implements ObservableStock {
    private final String company;
    private int price;
    private final List<StockObserver> observers = new ArrayList<>();

    public Stock(String company) {
        this.company = company;
    }

    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(company, price);
        }
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void attach(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(StockObserver observer) {
        observers.remove(observer);
    }
}
