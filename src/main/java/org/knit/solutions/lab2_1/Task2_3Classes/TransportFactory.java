package org.knit.solutions.lab2_1.Task2_3Classes;

public class TransportFactory {

    public static Transport createTransport(String travelType) throws ClassNotFoundException {
        switch (travelType) {
            case "fast_delivery":
                return new Motorbike();
            case "long_family_journey":
                return new RV();
            case "business":
                return new BusinessCar();
            default:
                throw new ClassNotFoundException("Некорректный тип поездки");
        }
    }
}
