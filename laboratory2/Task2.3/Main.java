package Semestr_2.Task3;

public class Main {
    public static void main(String[] args) {
        try {
            Transport businessCar = TransportFactory.createTransport("business");
            System.out.println(businessCar.getSpecifications());

            Transport familyVan = TransportFactory.createTransport("family");
            System.out.println(familyVan.getSpecifications());

            Transport motorbike = TransportFactory.createTransport("delivery");
            System.out.println(motorbike.getSpecifications());

            Transport error = TransportFactory.createTransport("error");
            System.out.println(error.getSpecifications());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
