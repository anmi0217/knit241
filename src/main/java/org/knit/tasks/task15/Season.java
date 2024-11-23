package org.knit.tasks.task15;

public enum Season {
    SPRING("Warm", "Woman's Day"),
    SUMMER("Hot", "Children's Day"),
    AUTUMN("Cool", "Halloween"),
    WINTER("Cold", "New Year");

    private final String temperature;
    private final String holiday;

    Season(String temperature, String holiday) {
        this.temperature = temperature;
        this.holiday = holiday;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHoliday() {
        return holiday;
    }
}
