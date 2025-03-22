package org.knit.solutions.org.lab5;

public class ShopItem {
    private String name; // Наименование
    private int price; // Цена
    private int quantity; // Количество
    private String color; // Цвет

    public ShopItem(String name, int price, int quantity, String color) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return String.format("%s: %d руб. за штуку, цвет: %s, количество: %d", name, price, color, quantity);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ShopItem)) return false;

        ShopItem other = (ShopItem) obj;
        return name.equals(other.name) && price == other.price && color.equals(other.color);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + price + color.hashCode();
    }
}
