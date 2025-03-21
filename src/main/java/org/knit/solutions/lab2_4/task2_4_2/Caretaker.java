package org.knit.solutions.lab2_4.task2_4_2;

import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> saveHistory = new Stack<>();

    public void saveText(TextEditor text) {
        saveHistory.push(text.save());
        System.out.println("Изменения сохранены.");
    }

    public void loadLastSave(TextEditor text) {
        if (!saveHistory.isEmpty()) {
            text.restore(saveHistory.pop());
            System.out.println("Последнее сохранение загружено.");
        } else {
            System.out.println("Нет сохранённых изменений.");
        }
    }
}
