package org.knit.solutions.task37;

import java.util.Stack;

public class TextTaker {
    private final Stack<TextMemento> history = new Stack<>();
    private final TextEditor textEditor;

    public TextTaker(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void saveText() {
        history.push(textEditor.save());
        System.out.println("Изменения сохранены.");
    }

    public void undoChanges() {
        if (history.isEmpty()) {

            System.out.println("История изменений пуста.");
        } else {
            textEditor.undo(history.pop());
            System.out.println("Отмена последнего изменения.");
        }
    }
}
