package org.knit.solutions.ClassesSem1.lab5.Task8;

import java.util.Objects;

public class ShopItem {
    private String name;
    private int price;
    private int quantity;

    public ShopItem(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "name: " + name + "; price: " + price + "; quantity: " + quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ShopItem shopItem = (ShopItem) obj;
        return shopItem.price == price && quantity == shopItem.getQuantity() && name.equals(shopItem.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}
