package org.knit.tasks.task28;

public class Task28 {
    public static void main(String[] args) {
        String[] types = {"business", "family", "delivery", "truck"};
        for (String type : types) {
            try {
                Transport transport = TransportFactory.createTransport(type);
                System.out.println(transport.getFeatures());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
