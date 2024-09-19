package org.knit.samples.lection1;

public class Car {
    private String color; // Цвет автомобиля
    private String brand; // Марка автомобиля
    private String model; // Модель автомобиля

    public Car(String color, String brand, String model) {
        this.color = color;
        this.brand = brand;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
