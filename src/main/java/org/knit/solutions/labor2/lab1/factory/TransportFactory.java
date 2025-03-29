package org.knit.solutions.labor2.lab1.factory;

public class TransportFactory {
    public Transport createTransport(String tripType) throws Exception {
        switch (tripType){
            case "business":
                return new BusinessCar();
            case "family":
                return new FamilyVan();
            case "dilivery":
                return new Motorbike();
            default:
                throw new Exception("Нет транспорта для "+ tripType);
        }
    }
}
