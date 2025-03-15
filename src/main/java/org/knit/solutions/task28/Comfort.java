package org.knit.solutions.task28;

public enum Comfort {
    LOW("низкий"),
    MEDIUM("средний"),
    HIGH("высокий");

    private final String level;

    Comfort(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
