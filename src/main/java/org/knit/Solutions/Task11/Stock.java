package org.knit.Solutions.Task11;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String name;
    private double price;
    private List<StockObserver> observers = new ArrayList<>();

    public Stock(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    void registerObserver(StockObserver observer){
        observers.add(observer);
    }
    void removeStock(StockObserver observer){
        observers.remove(observer);
    }
    void notifyObservers(){
        for (StockObserver observer : observers){
            observer.update(name, price);
        }
    }
}
