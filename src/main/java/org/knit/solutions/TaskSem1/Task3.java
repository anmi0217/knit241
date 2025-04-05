package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab2.Task3.Calculator;

import java.util.Scanner;

import org.knit.TaskDescription;

/***
 * Задача 3
 * Реализация консольного калькулятора
 *
 * Создайте класс Calculator с методами:
 * - add(double a, double b) — сложение
 * - subtract(double a, double b) — вычитание
 * - multiply(double a, double b) — умножение
 * - divide(double a, double b) — деление (с проверкой на ноль)
 *
 * В методе main:
 * - Считывайте два числа и оператор (+, -, *, /)
 * - Выполняйте операцию, используя Calculator
 * - Обрабатывайте ошибки (деление на ноль)
 * - Завершайте работу по команде "exit"
 */

@TaskDescription(taskNumber = 3,
        taskDescription = "Реализация консольного калькулятора",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task3 implements Solution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            double first_number = 0;
            System.out.print("Введите первое число (Для выхода из программы введите \"exit\": ");
            String input = scanner.next();
            if (input.equals("exit")) {
                System.out.println("Завершение программы.");
                System.exit(0);
            } else {
                first_number = Double.parseDouble(input);
            }

            System.out.print("Введите оператор (+, -, *, /): ");
            String operator = scanner.next();

            System.out.print("Введите второе число: ");
            double second_number = scanner.nextDouble();
//            System.out.println(first_number);
//            System.out.println(operator);
//            System.out.println(second_number);

            Calculator Calc = new Calculator();

            switch (operator) {
                case "+":
                    Calc.add(first_number, second_number);
                    break;
                case "-":
                    Calc.subtract(first_number, second_number);
                    break;
                case "*":
                    Calc.multiply(first_number, second_number);
                    break;
                case "/":
                    if (second_number != 0) {
                        Calc.divide(first_number, second_number);
                    } else {
                        System.out.println("Деление на 0! Введите другое число.");
                    }
                    break;
                default:
                    System.out.println("Введён неизвестный оператор!");
            }
        }
    }
}
