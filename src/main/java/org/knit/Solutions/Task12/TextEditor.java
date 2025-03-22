package org.knit.Solutions.Task12;

import java.util.Stack;

public class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void addText(String newText) {
        text.append(newText);
    }

    public String getText() {
        return text.toString();
    }

    public Memento saveState() {
        return new Memento(text.toString());
    }

    public void restoreState(Memento memento) {
        text = new StringBuilder(memento.getText());
    }
}
