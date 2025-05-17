package org2.lab1;

public class Problem {
    public Problem(int difficult, String description) {
        this.difficult = difficult;
        this.description = description;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int difficult;
    private String description;
}

