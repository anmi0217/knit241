package org.labs.Tasks2.Task1;

class Complaint {
    private String description;
    private int difficulty;

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
