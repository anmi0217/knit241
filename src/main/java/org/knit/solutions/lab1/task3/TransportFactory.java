package org.knit.solutions.lab1.task3;

public class TransportFactory {
    public static Transport createTransport(String tripType) {
        if (tripType == null) {
            throw new IllegalArgumentException("Тип поездки не может быть null!");
        }
        switch (tripType.toLowerCase()) {
            case "business":
                return new BusinessCar();
            case "family":
                return new FamilyVan();
            case "delivery":
                return new Motorbike();
            default:
                throw new IllegalArgumentException("Неизвестный тип транспорта: " + tripType);
        }
    }
}

