package org.knit.solutions.org.labs1;

import java.util.Scanner; //считывает данные из источника, которые для него указываются. Далее распознает информацию и обрабатывает


public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }
    public double subtract(double a, double b) {
        return a - b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно.");
        }
        return a / b;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();


        while (true) {
            System.out.print("Введите первое число (или 'exit' для выхода): ");
            String input = scanner.next();

            // проверка на команду выхода
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            // преобразование ввода в число
            double num1;
            try {
                num1 = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное число.");
                continue;
            }

            // ввод оператора
            System.out.print("Введите оператор (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            // ввод второго числа
            System.out.print("Введите второе число: ");
            double num2;
            try {
                num2 = Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное число.");
                continue;
            }

            // выполнение операции
            try {
                double result;
                switch (operator) {
                    case '+':
                        result = calculator.add(num1, num2);
                        break;
                    case '-':
                        result = calculator.subtract(num1, num2);
                        break;
                    case '*':
                        result = calculator.multiply(num1, num2);
                        break;
                    case '/':
                        result = calculator.divide(num1, num2);
                        break;
                    default:
                        System.out.println("Ошибка: Некорректный оператор.");
                        continue;
                }
                System.out.println("Результат: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}