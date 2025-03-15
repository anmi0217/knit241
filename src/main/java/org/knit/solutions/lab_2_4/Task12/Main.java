package org.knit.solutions.lab_2_4.Task12;

import org.knit.TasksDescription;

/*
Задача 12: Реализация системы отмены изменений в текстовом редакторе

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

public class Main {
    @TasksDescription(number = 12, name = "Паттерн Memento (Хранитель)")
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
        textEditor.undo();
        textEditor.undo();
        System.out.println(textEditor.getCurrentText());
    }
}