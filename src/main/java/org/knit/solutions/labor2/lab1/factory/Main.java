package org.knit.solutions.labor2.lab1.factory;

public class Main {
    public static void main(String[] args) throws Exception {
        TransportFactory transportFactory = new TransportFactory();
        try {
            Transport transport1 = transportFactory.createTransport("business");
            System.out.println(transport1.getSpetifications());
        } catch (Exception e) {
            System.out.println("Неверный тип поездки");
        }
    }
}
