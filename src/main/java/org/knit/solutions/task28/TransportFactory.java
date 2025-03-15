package org.knit.solutions.task28;

public class TransportFactory {
    public static Transport createTransport(String type) throws Exception {
        switch (type) {
            case "business":
                return new BusinessCar();
            case "family":
                return new Minivan();
            case "delivery":
                return new Motorcycle();
            default:
                throw new Exception("Передан неизвестный тип транспорта.");
        }
    }
}
