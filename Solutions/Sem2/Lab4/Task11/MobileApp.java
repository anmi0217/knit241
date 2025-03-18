package org2.lab11;

// Класс мобильного приложения (наблюдатель)
class MobileApp implements StockObserver {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("Мобильное приложение: Пользователь " + user + ", цена акции " + stockName + " изменилась: " + price);
    }
}
