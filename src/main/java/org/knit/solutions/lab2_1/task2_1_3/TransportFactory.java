package org.knit.solutions.lab2_1.task2_1_3;

public class TransportFactory {
    public static Transport createTransport(String type) {
        switch (type) {
            case "business":
                return new BusinessCar();
            case "family":
                return new FamilyVan();
            case "delivery":
                return new Motorbike();
            default:
                throw new RuntimeException("Неизвестный тип!");
        }
    }
}
