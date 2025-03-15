package org.knit.solutions.task37;

public class TextEditor {
    private String text = "";

    public String getText() {
        return text;
    }

    public void addText(String text) {
        this.text += text + '\n';
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void undo(TextMemento textMemento) {
        text = textMemento.getText();
    }
}
