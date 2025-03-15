package org.knit.solutions.Task12;

import org.knit.solutions.TasksDescription;

/*
Разработайте систему, позволяющую сохранять состояния текста в редакторе и откатывать изменения назад.

Требуется:
Создать класс TextEditor, который содержит текущий текст документа.
Создать класс Memento, который будет хранить снимок состояния текста.
Реализовать Caretaker, который управляет историей изменений (например, стек сохранённых состояний).
Реализовать методы saveState() и undo() для сохранения и отката изменений.

Пример работы:
Пользователь вводит текст "Hello, world!".
Он сохраняет текущее состояние.
Затем добавляет " How are you?".
Нажимает "Отменить" и возвращается к "Hello, world!".
Дополнительно: Реализуйте возможность нескольких уровней отката.
 */

@TasksDescription(number = 12, name = "Паттерн Memento (Хранитель)")
public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.setText("Hello, world!");
        System.out.println("Начальный текст: " + editor.getText());
        caretaker.saveState(editor);

        editor.appendText(" How are you?");
        System.out.println("После добавления: " + editor.getText());
        caretaker.saveState(editor);

        editor.appendText(" I hope you are doing well.");
        System.out.println("После второго добавления: " + editor.getText());
        caretaker.saveState(editor);

        caretaker.undo(editor);
        System.out.println("После первого отката: " + editor.getText());

        caretaker.undo(editor);
        System.out.println("После второго отката: " + editor.getText());

        caretaker.undo(editor);
        System.out.println("После третьего отката: " + editor.getText());
    }
}
