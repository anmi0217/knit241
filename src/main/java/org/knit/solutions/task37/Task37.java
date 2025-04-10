package org.knit.solutions.task37;

public class Task37 {
    public static void main(String[] args) {
        TextEditor notepad = new TextEditor();
        TextTaker textTaker = new TextTaker(notepad);

        textTaker.undoChanges();
        System.out.println(notepad.getText());

        System.out.println("Добавление строки текста.");
        notepad.addText("Hello, world!");
        System.out.println(notepad.getText());
        textTaker.saveText();
        System.out.println(notepad.getText());

        System.out.println("Добавление строки текста.");
        notepad.addText("How are you?");
        System.out.println(notepad.getText());
        textTaker.undoChanges();
        System.out.println(notepad.getText());
    }
}
