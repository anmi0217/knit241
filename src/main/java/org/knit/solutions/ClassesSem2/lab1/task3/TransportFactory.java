package org.knit.solutions.ClassesSem2.lab1.task3;

public class TransportFactory {
    public static Transport createTransport(String tripType) {
        if (tripType == null) {
            throw new IllegalArgumentException("Поездка не должна быть null!");
        }
        switch (tripType) {
            case "business":
                return new BusinessCar();
            case "family":
                return new FamilyVan();
            case "delivery":
                return new Motorbike();
            default:
                throw new IllegalArgumentException("Такого типа нет! " + tripType);
        }
    }
}
