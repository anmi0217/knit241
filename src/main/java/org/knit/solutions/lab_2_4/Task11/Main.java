package org.knit.solutions.lab_2_4.Task11;

import org.knit.TasksDescription;

/*
Задача 11: Реализация системы уведомлений в биржевом приложении

Вы разрабатываете приложение для биржевой торговли, где пользователи могут подписываться на обновления акций определённых компаний.

Требуется:
Создать класс Stock (акция), который хранит информацию о текущей цене и может уведомлять подписчиков об изменении цены.
Создать интерфейс StockObserver и реализовать его в классах MobileApp и EmailNotifier, которые получают уведомления при изменении цены.
Реализовать механизм подписки и отписки для StockObserver.

Пример работы:
Пользователь подписывается на акции компании "Tesla".
Когда цена акции изменяется, приложение отправляет уведомления подписчикам.
Если пользователь отписался, он больше не получает уведомления.

Дополнительно: Добавьте возможность подписки на акции нескольких компаний.
 */

public class Main {
    @TasksDescription(number = 11, name = "Паттерн Observer (Наблюдатель)")
    public static void main(String[] args) {
        Stock teslaStock = new Stock("Tesla", 100);

        StockObserver mobileApp1 = new MobileApp();
        StockObserver emailNotifier1 = new EmailNotifier();

        teslaStock.addObserver(mobileApp1);
        teslaStock.addObserver(emailNotifier1);

        teslaStock.setCurrentPrice(120);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        teslaStock.setCurrentPrice(110);
    }
}