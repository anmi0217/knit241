package org.knit.lab9;

import java.util.Scanner;

public class Task14 {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текущий свет (RED, YELLOW, GREEN): ");
        String light = scanner.nextLine().toUpperCase();
        System.out.println(TrafL.TrafficLight.getNextLight(light));
    }
}
