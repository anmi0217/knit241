package org.knit.lab9;

public class Seas {
    enum Seasons {
        WINTER("холодно", "новый год"),
        SUMMER("жарко", "день Ивана Купала"),
        AUTOMN("прохладно", "Хэллоуин"),
        SPRING("тепло", "масленица");

        private final String w;
        private final String h;

        Seasons(String weather, String holiday) {
            w = weather;
            h = holiday;
        }

        String getWeather() {
            return w;
        }

        String getHoliday() {
            return h;
        }
    }
}