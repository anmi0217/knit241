package org.knit.solutions.lab_2_4.Task12;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> historyStack;

    public Caretaker() {
        this.historyStack = new Stack<>();
    }

    public String popLastState() {
        return historyStack.pop().getText();
    }

    public void saveState(String text) {
        Memento memento = new Memento(text);
        this.historyStack.add(memento);
    }
}
