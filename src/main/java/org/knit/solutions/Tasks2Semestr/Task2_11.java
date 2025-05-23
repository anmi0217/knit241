package org.knit.solutions.Tasks2Semestr;


import org.knit.TaskDescription;
import org.knit.solutions.lab4.task1.EmailNotifier;
import org.knit.solutions.lab4.task1.MobileApp;
import org.knit.solutions.Solution;
import org.knit.solutions.lab4.task1.Stock;

/**
 * Задача 11: Реализация системы уведомлений в биржевом приложении
 * <p>
 * Описание:
 * - Класс Stock хранит цену акции и уведомляет подписчиков об изменении.
 * - Интерфейс StockObserver реализуют классы MobileApp и EmailNotifier для получения уведомлений.
 * - Реализовать подписку и отписку для StockObserver.
 * - Возможность подписки на несколько акций.
 */

@TaskDescription(
        taskNumber = 11,
        taskDescription = "Реализация системы уведомлений в биржевом приложении",
        href = "org/knit/solutions/taskExampleClasses/README.md"
)
public class Task2_11 implements Solution {
    @Override
    public void execute() {
        Stock market = new Stock();

        MobileApp mobileClient = new MobileApp();
        EmailNotifier emailClient = new EmailNotifier();

        market.subscribe(mobileClient);
        market.subscribe(emailClient);

        market.updatePrice("Tesla", 25.5, 60);
        market.updatePrice("Sberbank", 0.5, 3000);

        System.out.println("\nОтписываем MobileApp и обновляем данные:");
        market.unsubscribe(mobileClient);

        market.updatePrice("Tesla", 30.0, 55);
        market.updatePrice("Sberbank", 0.7, 2500);
    }
}

