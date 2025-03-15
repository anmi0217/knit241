package org.knit.solutions.lab9;

public class Task15 {
    Seas seasons = new Seas();

    public void print() {
        for (Seas.Seasons s : Seas.Seasons.values()) {
            System.out.println(s + ": " + s.getWeather() + ", типичный праздник - " + s.getHoliday());
        }
    }
}
