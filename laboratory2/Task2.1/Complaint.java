package Semestr_2.Task1;

class Complaint {
    private String description;
    private int complexityLevel;

    public Complaint(String description, int complexityLevel) {
        this.description = description;
        this.complexityLevel = complexityLevel;
    }

    public String getDescription() {
        return description;
    }

    public int getComplexityLevel() {
        return complexityLevel;
    }
}