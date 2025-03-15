package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task11.EmailNotifier;
import org.knit.solutions.Task11.MobileApp;
import org.knit.solutions.Task11.Stock;

/*
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

@TaskDescription(taskNumber = 11, taskDescription = "Паттерн Observer (Наблюдатель)")
public class Task11Solution implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 11 запущена");

        Stock teslaStock = new Stock("Tesla", 700);
        Stock appleStock = new Stock("Apple", 150);

        MobileApp mobileApp = new MobileApp("Ivan");
        EmailNotifier emailNotifier = new EmailNotifier("ivan@example.com");

        teslaStock.subscribe(mobileApp);
        teslaStock.subscribe(emailNotifier);
        appleStock.subscribe(emailNotifier);

        teslaStock.setPrice(710);
        appleStock.setPrice(155);

        teslaStock.unsubscribe(emailNotifier);

        teslaStock.setPrice(720);
    }
}
