package org.knit.solutions.ClassesSem2.lab4.task2;

// Memento (Снимок состояния)
class Memento {
    private final String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
