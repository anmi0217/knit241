//23
package org.knit.solutions.org.lab10;

public class PrintType {

    // Универсальный метод для печати типа объекта
    public static <T> void printType(T object) {
        // Получение и вывод имени класса объекта
        System.out.println(object.getClass().getName());
    }

    public static void main(String[] args) {
        // Пример с целым числом
        printType(123);

        // Пример с строкой
        printType("Hello");

        // Пример с числом с плавающей точкой
        printType(12.34);
    }
}
