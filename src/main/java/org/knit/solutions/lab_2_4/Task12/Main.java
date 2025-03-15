package org.knit.solutions.lab_2_4.Task12;

public class Main {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        TextEditor textEditor = new TextEditor(caretaker);

        textEditor.addText("qwerty");
        textEditor.saveState();
        textEditor.addText(" 123");
        textEditor.saveState();
        textEditor.addText(" hehehehe");
        textEditor.saveState();

        System.out.println(textEditor.getCurrentText());
        textEditor.undo();
        System.out.println(textEditor.getCurrentText());
        textEditor.undo();
        System.out.println(textEditor.getCurrentText());
        textEditor.undo();
        System.out.println(textEditor.getCurrentText());
    }
}