package org2.lab12;


// Класс Memento (хранитель состояния)
class TextMemento {
    private final String text; // Сохраненное состояние текста

    public TextMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}