//14
package org.knit.solutions.org.lab9;

enum Season {
    WINTER("Холодно", "Новый год"),
    SPRING("Тепло", "Пасха"),
    SUMMER("Жарко", "День Независимости"),
    AUTUMN("Прохладно", "День учителя");

    private final String temperature;
    private final String typicalHoliday;

    Season(String temperature, String typicalHoliday) {
        this.temperature = temperature;
        this.typicalHoliday = typicalHoliday;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getTypicalHoliday() {
        return typicalHoliday;
    }
}

public class SeasonApp {
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(season.name() + ": " + season.getTemperature()
                    + ", типичный праздник - " + season.getTypicalHoliday());
        }
    }
}
