//15
package org.knit.solutions.org.lab9;
import java.util.Scanner;

enum TrafficLight {
    RED,
    YELLOW,
    GREEN;

    public TrafficLight getNextLight() {
        switch (this) {
            case RED:
                return GREEN;
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
            default:
                throw new IllegalArgumentException("недопустимый сигнал светофора");
        }
    }
}

public class TrafficLightApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String input = scanner.nextLine().toUpperCase();

        try {
            TrafficLight currentLight = TrafficLight.valueOf(input);
            TrafficLight nextLight = currentLight.getNextLight();
            System.out.println("Следующий сигнал: " + nextLight);
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректный ввод. Пожалуйста, введите RED, YELLOW или GREEN.");
        } finally {
            scanner.close();
        }
    }
}
