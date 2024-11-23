package org.knit.tasks.task14;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(
                "Введите текущий сигнал светофора (%s, %s, %s): ",
                TrafficLight.RED, TrafficLight.YELLOW, TrafficLight.GREEN
        );
        TrafficLight light = TrafficLight.valueOf(scanner.nextLine());
        System.out.println("Следующий сигнал светофора: " + light.getNextLight());
    }
}
