package org.knit.tasks.task28;

public enum Capacity {
    ONE("1 человек"),
    FOUR("4 человека"),
    SIX("6 человек");

    private final String value;

    Capacity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
