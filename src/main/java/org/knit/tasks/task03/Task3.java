package org.knit.tasks.task03;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> operators = new HashSet<>(Set.of("+", "-", "*", "/"));
        Calculator calculator = new Calculator();
        while (true) {
            double a;
            double b;
            System.out.print("Введите первое число: ");
            if (scanner.hasNextDouble()) {
                a = scanner.nextDouble();
            } else if (scanner.next().equals("exit")) {
                System.out.println("Выход из программы.");
                break;
            } else {
                System.out.println("Ошибка: Некорректное число.\n");
                continue;
            }
            System.out.print("Введите оператор (+, -, *, /): ");
            String operator = scanner.next();
            if (operator.equals("exit")) {
                System.out.println("Выход из программы.");
                break;
            } else if (!operators.contains(operator)) {
                System.out.println("Ошибка: Некорректный оператор.\n");
                continue;
            }
            System.out.print("Введите второе число: ");
            if (scanner.hasNextDouble()) {
                b = scanner.nextDouble();
            } else if (scanner.next().equals("exit")) {
                System.out.println("Выход из программы.");
                break;
            } else {
                System.out.println("Ошибка: Некорректное число.\n");
                continue;
            }
            switch (operator) {
                case "+":
                    System.out.println("Результат: " + calculator.add(a, b));
                    break;
                case "-":
                    System.out.println("Результат: " + calculator.subtract(a, b));
                    break;
                case "*":
                    System.out.println("Результат: " + calculator.multiply(a, b));
                    break;
                case "/":
                    if (b == 0) {
                        System.out.println("Ошибка: Деление на ноль невозможно.");
                    } else {
                        System.out.println("Результат: " + calculator.divide(a, b));
                    }
                    break;
            }
            System.out.println();
        }
    }
}
