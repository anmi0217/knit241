package org.knit.solutions.task15;

public class Task15 {
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.printf(
                    "It's usually %s in %s.\n",
                    season.getTemperature().toLowerCase(),
                    season.toString().toLowerCase()
            );
            System.out.printf(
                    "The most important holiday of %s is %s.\n",
                    season.toString().toLowerCase(),
                    season.getHoliday()
            );
        }
    }
}
