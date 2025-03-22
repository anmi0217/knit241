package org.knit.solutions.org2.lab11;

import java.util.ArrayList;
import java.util.List;

// Класс акции
class Stock {
    private String name; // Название акции
    private double price; // Текущая цена
    private List<StockObserver> observers = new ArrayList<>(); // Список подписчиков

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Метод для изменения цены
    public void setPrice(double price) {
        if (this.price != price) { // Если цена изменилась
            this.price = price;
            notifyObservers(); // Уведомляем всех подписчиков
        }
    }

    // Метод для добавления подписчика
    public void addObserver(StockObserver observer) {
        observers.add(observer);
        System.out.println("Подписчик добавлен: " + observer.getClass().getSimpleName());
    }

    // Метод для удаления подписчика
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
        System.out.println("Подписчик удален: " + observer.getClass().getSimpleName());
    }

    // Метод для уведомления всех подписчиков
    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(name, price);
        }
    }

    public String getName() {
        return name;
    }
}