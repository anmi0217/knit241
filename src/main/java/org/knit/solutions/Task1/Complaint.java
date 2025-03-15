package org.knit.solutions.Task1;

public class Complaint {
    private final String description;
    private final int difficulty;

    public Complaint(String description, int difficulty) {
        this.description = description;
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
