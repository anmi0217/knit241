package org.knit.solutions.lab2_4.task2_4_2;

import java.util.Scanner;

public class Task2_4_2 {
    public static void Run() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        TextEditor te = new TextEditor(text);
        Caretaker saver = new Caretaker();

        te.getText();

        saver.saveText(te);
        te.editText("Другой текст...");
        te.getText();

        System.out.println("\nОткат изменений в тексте:");
        saver.loadLastSave(te);
    }
}
