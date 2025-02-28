package org.knit.lab10;

public class Task23 {
    public void execute() {
        printType(123);
        printType("Hello");
        printType(125.500);
        printType(true);
        printType(new Object());
        printType(null);
    }

    public static <T> void printType(T obj) {
        if (obj != null) {
            System.out.println(obj.getClass().getName());
        } else {
            System.out.println("null");
        }
    }
}
