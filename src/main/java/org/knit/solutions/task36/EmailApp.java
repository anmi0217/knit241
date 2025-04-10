package org.knit.solutions.task36;

public class EmailApp implements StockObserver {
    @Override
    public void update(String company, int price) {
        System.out.printf(
                "Яндекс Почта: Текущая стоимость акций компании %s составляет %d руб.\n",
                company, price
        );
    }
}
