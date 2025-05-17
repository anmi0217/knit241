package org.knit.solutions.org2.lab3;

import org.knit.solutions.annotations.Discription;

@Discription(value = 2, name = "Фабрика")
public class Task3 {
    public static void main(String[] args) {
        try {
            Transport businessCar = TransportFactory.createTransport("business");
            System.out.println(businessCar.getSpecifications());

            Transport familyVan = TransportFactory.createTransport("family");
            System.out.println(familyVan.getSpecifications());

            Transport motorbike = TransportFactory.createTransport("delivery");
            System.out.println(motorbike.getSpecifications());

            // Неизвестный тип транспорта
            Transport unknown = TransportFactory.createTransport("unknown");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
