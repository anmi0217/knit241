package org.knit.Solutions.Task11;

public class EmailNotifier implements StockObserver{
    private String user;

    public EmailNotifier(String user){
        this.user = user;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("EmailNotifier: уважаемый " + user + " цена на акцию " + stockName + " изменилась на: " + price);
    }
}
