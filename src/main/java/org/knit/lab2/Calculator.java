package org.knit.lab2;

public class Calculator {

    public String inputer(double a, String operand, double b) {
        switch (operand) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
        }
        return "Это не знакомый мне оператор!";
    }

    public String add(double a, double b) {
        return String.valueOf(a + b);
    }

    public String subtract(double a, double b) {
        return String.valueOf(a - b);
    }

    public String multiply(double a, double b) {
        return String.valueOf(a * b);
    }

    public String divide(double a, double b) {
        if (b == 0) {
            return "Делить на 0 нельзя!";
        } else {
            return String.valueOf(a / b);
        }
    }
}