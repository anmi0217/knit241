package org.knit.solutions.Task3;

class Motorbike implements Transport {
    private String specifications;

    public Motorbike() {
        this.specifications = "Motorbike: предназначен для быстрой доставки";
    }

    @Override
    public String getSpecifications() {
        return specifications;
    }
}
