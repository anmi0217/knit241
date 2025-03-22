package org.knit.solutions.lab2_1.Task2_1Classes;

public class ClientProblem {
    private String theme;
    private String description;
    private ProblemDifficulty difficulty;

    public ClientProblem(ProblemDifficulty difficulty, String theme, String description) {
        this.difficulty = difficulty;
        this.theme = theme;
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }

    public String getDescription() {
        return description;
    }

    public ProblemDifficulty getDifficulty() {
        return difficulty;
    }
}
