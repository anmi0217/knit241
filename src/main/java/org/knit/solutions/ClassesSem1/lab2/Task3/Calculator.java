package org.knit.solutions.ClassesSem1.lab2.Task3;

public class Calculator {
    private double summ;
    private double subtract;
    private double multiply;
    private double divide;

    public void add(double a, double b) {
        summ = a + b;
        System.out.println(summ);
    }

    public void subtract(double a, double b) {
        subtract = a - b;
        System.out.println(subtract);
    }

    public void multiply(double a, double b) {
        multiply = a * b;
        System.out.println(multiply);
    }

    public void divide(double a, double b) {
        divide = a / b;
        System.out.println(divide);
    }
}