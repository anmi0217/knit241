package org.knit.solutions.org2.lab12;

import java.util.Stack;

// Класс Caretaker (управляет историей изменений)
public class Caretaker {
    private final Stack<TextMemento> history = new Stack<>(); // Стек для хранения состояний

    // Метод для сохранения состояния
    public void saveState(TextMemento memento) {
        history.push(memento);
    }

    // Метод для отмены последнего изменения
    public TextMemento undo() {
        if (!history.isEmpty()) {
            return history.pop(); // Возвращаем последнее сохраненное состояние
        }
        return null; // Если история пуста
    }
}