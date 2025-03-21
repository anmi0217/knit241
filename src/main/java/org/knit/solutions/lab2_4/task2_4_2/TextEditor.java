package org.knit.solutions.lab2_4.task2_4_2;

public class TextEditor {
    private String text;

    public TextEditor(String text) {
        this.text = text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void getText() {
        System.out.println(text);
    }

    public void editText(String text) {
        this.text = text;
    }

    public void restore(Memento memento) {
        this.text = memento.getText();
        System.out.println("Восстановлено:\n" + text);
    }
}
