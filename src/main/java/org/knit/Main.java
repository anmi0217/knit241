package org.knit;

public class Main {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 100; i += 10) {
            for (int j = i; j < i + 10; j++) {
                result.append(j);
                if (j < i + 9) {
                    result.append(",");
                } else {
                    result.append("\n");
                }
            }
        }
        System.out.println(result);
    }
}