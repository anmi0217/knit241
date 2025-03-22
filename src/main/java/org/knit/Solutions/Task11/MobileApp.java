package org.knit.Solutions.Task11;

public class MobileApp implements StockObserver{
    private String user;

    public MobileApp(String user){
        this.user = user;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("MobileApp: уважаемый " + user + " цена на акцию " + stockName + " изменилась на: " + price);
    }
}
