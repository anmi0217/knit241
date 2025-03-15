package org.knit.solutions.Task11;

class MobileApp implements StockObserver {
    private final String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(Stock stock, double oldPrice, double newPrice) {
        System.out.println("MobileApp [" + userName + "]: Акция " + stock.getCompanyName() +
                " изменилась с " + oldPrice + " на " + newPrice);
    }
}
