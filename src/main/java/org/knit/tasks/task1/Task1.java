package org.knit.tasks.task1;

import java.util.StringJoiner;

public class Task1 {
    public void execute() {
        for (int i = 1; i < 100; i += 10) {
            StringJoiner joiner = new StringJoiner(",");
            for (int j = i; j < i + 10; j++) {
                joiner.add(Integer.toString(j));
            }
            System.out.println(joiner);
        }
    }
}
