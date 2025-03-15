package org.knit.solutions.lab2_1.task2_1_1;

public class Problem {
    private final int difficult;
    private final String description;

    public Problem(int difficult, String description) {
        this.difficult = difficult;
        this.description = description;
    }

    public int getDifficult() {
        return difficult;
    }

    public String getDescription() {
        return description;
    }
}
