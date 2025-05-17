package org.knit.solutions.org2.lab12;

// Класс TextEditor (редактор текста)
public class TextEditor {
    private String text; // Текущий текст

    public TextEditor() {
        this.text = "";
    }

    // Метод для добавления текста
    public void addText(String newText) {
        this.text += newText;
        System.out.println("Текущий текст: " + text);
    }

    // Метод для сохранения текущего состояния
    public TextMemento saveState() {
        System.out.println("Состояние сохранено.");
        return new TextMemento(text);
    }

    // Метод для восстановления состояния
    public void restoreState(TextMemento memento) {
        this.text = memento.getText();
        System.out.println("Текст восстановлен: " + text);
    }

    // Метод для получения текущего текста
    public String getText() {
        return text;
    }
}