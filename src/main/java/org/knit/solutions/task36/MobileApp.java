package org.knit.solutions.task36;

public class MobileApp implements StockObserver {
    @Override
    public void update(String company, int price) {
        System.out.printf(
                "Т-Банк: Текущая стоимость акций компании %s составляет %d руб.\n",
                company, price
        );
    }
}
