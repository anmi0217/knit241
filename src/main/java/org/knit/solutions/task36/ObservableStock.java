package org.knit.solutions.task36;

public interface ObservableStock {
    void setPrice(int price);

    void attach(StockObserver observer);

    void detach(StockObserver observer);
}
