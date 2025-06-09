package org.knit.solutions.org2.lab11;

// Класс email-уведомлений (наблюдатель)
public class EmailNotifier implements StockObserver {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("Email-уведомление: На адрес " + email + ", цена акции " + stockName + " изменилась: " + price);
    }
}
