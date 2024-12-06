package org.knit.samples.lection8;

public class GenericsApp {
    public static void main(String[] args) {
        ServiceResolver serviceResolver = new ServiceResolver();
        serviceResolver.runService(1);
    }
}
