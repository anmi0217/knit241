package org.knit.solutions.lab2_4.Task2_12Classes;

import java.util.Stack;

public class CareTaker {
    private final TextEditor relatedEditor;
    private final Stack<Memento> history = new Stack<>();

    public void addSave() {
        history.push(relatedEditor.returnState());
        System.out.println("Файл " + relatedEditor.getName() + " сохранен");
    }

    public void loadLastSave() {
        if (history.isEmpty()) {
            System.out.println("Нет сохраненных изменений");
            relatedEditor.restore(new Memento(relatedEditor.getName(), ""));
        } else {
            relatedEditor.restore(history.pop());
            System.out.println("Восстановлена предыдущая версия файла");
        }

    }

    public CareTaker(TextEditor relatedEditor) {
        this.relatedEditor = relatedEditor;
    }

}
