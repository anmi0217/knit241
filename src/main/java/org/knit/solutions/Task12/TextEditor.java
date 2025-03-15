package org.knit.solutions.Task12;

class TextEditor {
    private String text;

    public TextEditor() {
        this.text = "";
    }

    public void setText(String text) {
        this.text = text;
    }

    public void appendText(String addition) {
        this.text += addition;
    }

    public String getText() {
        return text;
    }

    public Memento saveState() {
        return new Memento(text);
    }

    public void restoreState(Memento memento) {
        this.text = memento.getState();
    }
}
