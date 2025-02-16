package org.knit.tasks.task28;

public enum Speed {
    LOW("низкая"),
    MEDIUM("средняя"),
    HIGH("высокая");

    private final String value;

    Speed(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
