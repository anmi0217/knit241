package org.knit.solutions.ClassesSem2.lab4.task2;

import java.util.Stack;

// Caretaker (Управление сохранениями)
public class Caretaker {
    private final Stack<Memento> saveHistory = new Stack<>();

    public void saveState(TextEditor notepad) {
        saveHistory.push(notepad.save());
        System.out.println("Текст сохранен.");
    }

    public void undo() {
        if (!saveHistory.isEmpty()) {
            saveHistory.pop();
            System.out.println("Произошёл откат изменений!");
        } else {
            System.out.println("Нет сохранённых состояний.");
        }
    }

    public void gatTempText() {
        if (!saveHistory.isEmpty()) {
            Memento temp = saveHistory.peek();
            System.out.println("Текущий текст: " + temp.getText());
        } else {
            System.out.println("Нет сохранённого текста");
        }
    }

}
