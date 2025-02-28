package org.knit.lab2_1.task2_1_3;

public class Task2_1_3 {
    public static void Run() {
        TransportFactory transportFactory = new TransportFactory();
        Transport business = TransportFactory.createTransport("business");
        System.out.println(business.getClass());
        System.out.println(business.getSpecifications());
        Transport family = TransportFactory.createTransport("family");
        System.out.println(family.getClass());
        System.out.println(family.getSpecifications());
        Transport delivery = TransportFactory.createTransport("delivery");
        System.out.println(delivery.getClass());
        System.out.println(delivery.getSpecifications());
        Transport non_exists = TransportFactory.createTransport("non_exits");
        System.out.println(non_exists.getClass());
        System.out.println(non_exists.getSpecifications());
    }
}
