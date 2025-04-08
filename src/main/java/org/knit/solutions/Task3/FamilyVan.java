package org.knit.solutions.Task3;

class FamilyVan implements Transport {
    private String specifications;

    public FamilyVan() {
        this.specifications = "Family Van: поддерживает перевозку 6+ пассажиров";
    }

    @Override
    public String getSpecifications() {
        return specifications;
    }
}