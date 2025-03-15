package org.knit.solutions.task26;

public class Problem {
    private final int difficulty;
    private final String description;

    public Problem(int difficulty, String description) {
        this.difficulty = difficulty;
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return String.format(
                "Сложность: %d. Описание: %s", difficulty, description
        );
    }
}
