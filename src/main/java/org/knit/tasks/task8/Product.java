package org.knit.tasks.task8;

import java.util.Objects;

public class Product {
    private final String name;
    private final int price;
    private final int mass;

    public Product(String name, int price, int mass) {
        this.name = name;
        this.price = price;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getMass() {
        return mass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, mass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return getName().equals(product.getName()) &&
                getPrice() == product.getPrice() &&
                getMass() == product.getMass();
    }

    @Override
    public String toString() {
        return String.format(
                "Product { name='%s', price=%d, mass=%d }",
                name, price, mass
        );
    }
}
