package org.knit.tasks.task1;

public class Task1 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 99; i += 10) {
            for (int j = i; j <= i + 9; j++) {
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
