package org.knit.lab2;

import java.util.Objects;
import java.util.Scanner;

/*

Необходимо создать консольное приложение-калькулятор, которое может выполнять основные арифметические операции (сложение, вычитание, умножение, деление) над двумя числами.

Условие:
Создайте класс Calculator, который будет содержать методы для выполнения следующих арифметических операций:

add(double a, double b) — сложение.
subtract(double a, double b) — вычитание.
multiply(double a, double b) — умножение.
divide(double a, double b) — деление (проверьте деление на ноль и выбросите исключение с соответствующим сообщением).
В главном классе программы создайте метод main, который:

Считывает два числа (целые или вещественные) с консоли.
Считывает оператор (+, -, *, /) с консоли.
Выполняет соответствующую операцию, используя методы класса Calculator, и выводит результат на экран.
Добавьте проверку деления на ноль и вывод сообщения об ошибке, если пользователь пытается разделить на ноль.

Программа должна продолжать работать до тех пор, пока пользователь не введет команду выхода (например, exit).

*/

public class Task3 {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String state = "";

        while (!Objects.equals(state, "exit")) {
            try {
                System.out.print("Введите a: ");
                double a = Double.parseDouble(scanner.nextLine());
                System.out.print("Введите (+, -, *, /): ");
                String operand = scanner.nextLine();
                System.out.print("Введите b: ");
                double b = Double.parseDouble(scanner.nextLine());

                Calculator calc = new Calculator();
                System.out.println("Результат: " + calc.inputer(a, operand, b));

                System.out.print(">> ");
                state = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println(e + " Неверный формат!");
            }
        }
    }
}
