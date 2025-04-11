package org.knit.Solutions.Task12;


import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> history = new Stack<>();

    public void saveState(TextEditor editor) {
        history.push(editor.saveState());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restoreState(history.pop());
        }
    }
}
