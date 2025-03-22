package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.lab2_4.Task2_11Classes.EmailNotifier;
import org.knit.solutions.lab2_4.Task2_11Classes.MobileApp;
import org.knit.solutions.lab2_4.Task2_11Classes.Stock;
import org.knit.solutions.lab2_4.Task2_11Classes.StockObserver;

@TaskDescription(taskNumber = 11, taskDescription = "Паттерн Observer (Наблюдатель). " +
        "Реализация системы уведомлений и подписок на них в биржевом приложении. ", href = "org/knit/solutions/lab2_4/Task2_11Classes")
public class Task2_11 implements Solution{
    public void execute() {
        Stock teslaStock = new Stock("Tesla", 30.0);
        Stock googleStock = new Stock("Google", 12.37);

        StockObserver phone = new MobileApp();
        StockObserver email = new EmailNotifier();

        teslaStock.addObserver(phone);
        teslaStock.addObserver(email);

        googleStock.addObserver(phone);

        teslaStock.setCurrentPrice(33.59);
        googleStock.setCurrentPrice(100.23);
    }
}
