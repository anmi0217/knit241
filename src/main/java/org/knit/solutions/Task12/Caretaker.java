package org.knit.solutions.Task12;

import java.util.Stack;

class Caretaker {
    private final Stack<Memento> history = new Stack<>();

    public void saveState(TextEditor editor) {
        history.push(editor.saveState());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            Memento memento = history.pop();
            editor.restoreState(memento);
        } else {
            System.out.println("Нет сохранённых состояний для отката.");
        }
    }

    public boolean canUndo() {
        return !history.isEmpty();
    }
}

