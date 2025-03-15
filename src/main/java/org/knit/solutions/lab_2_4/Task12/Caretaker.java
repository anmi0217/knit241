package org.knit.solutions.lab_2_4.Task12;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> historyStack;

    public Caretaker() {
        this.historyStack = new Stack<>();
    }

    public String popLastState() {
        if (historyStack.size() < 2) {
            return "";
        }
        int index = historyStack.size() - 2; // Индекс предпоследнего элемента
        Memento popped = historyStack.remove(index);
        return popped.getText();
    }

    public void saveState(String text) {
        Memento memento = new Memento(text);
        this.historyStack.add(memento);
    }
}
