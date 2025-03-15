package org.knit.solutions.task23;

public class Task23 {
    public static void main(String[] args) {
        printType(123);
        printType("Hello");
    }

    private static <T> void printType(T obj) {
        System.out.println(obj.getClass());
    }
}
