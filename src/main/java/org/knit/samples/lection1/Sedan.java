package org.knit.samples.lection1;

public class Sedan extends Car{
    private int doors; // Количество дверей
    private String bodyType; // Тип кузова

    public Sedan(String color, String brand, String model) {
        super(color, brand, model);
    }

    public Sedan(String color, String brand, String model, int doors, String bodyType) {
        super(color, brand, model);
        this.doors = doors;
        this.bodyType = bodyType;
    }

}
