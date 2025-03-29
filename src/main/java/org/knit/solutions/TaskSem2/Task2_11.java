package org.knit.solutions.TaskSem2;


import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.EmailNotifier;
import org.knit.solutions.ClassesSem2.lab4.task1.MobileApp;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem2.lab4.task1.Stock;

/**
 * Задача 11: Реализация системы уведомлений в биржевом приложении
 * <p>
 * Описание:
 * - Класс Stock хранит цену акции и уведомляет подписчиков об изменении.
 * - Интерфейс StockObserver реализуют классы MobileApp и EmailNotifier для получения уведомлений.
 * - Реализовать подписку и отписку для StockObserver.
 * - Возможность подписки на несколько акций.
 */

@TaskDescription(taskNumber = 11,
        taskDescription = "Реализация системы уведомлений в биржевом приложении",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_11 implements Solution {
    public void execute() {
        Stock station = new Stock();

        MobileApp phone = new MobileApp();
        EmailNotifier email = new EmailNotifier();

        station.addObserver(phone);
        station.addObserver(email);

        station.setPrice("Tesla", 25.5, 60);
        station.setPrice("Сбербанк", 0.5, 3000);

        System.out.println("\nУдаление одного подписчика (PhoneDisplay) и обновление цен:");
        station.removeObserver(phone);
        station.setPrice("Tesla", 30, 55);
        station.setPrice("Сбербанк", 0.7, 2500);
    }
}

