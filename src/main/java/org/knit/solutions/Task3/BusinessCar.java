package org.knit.solutions.Task3;


class BusinessCar implements Transport {
    private String specifications;

    public BusinessCar() {
        this.specifications = "Business Car: комфортный салон, кожаные сиденья";
    }

    @Override
    public String getSpecifications() {
        return specifications;
    }
}
