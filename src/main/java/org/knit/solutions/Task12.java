package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task12.Caretaker;
import org.knit.solutions.task12.TextEditor;

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
@TaskDescription(taskNumber = 12, taskDescription = "2. Паттерн Memento (Хранитель)")
public class Task12 implements Solution{

    @Override
    public void execute() {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.addText("Hello, world!");
        System.out.println("Current text: " + editor.getText());
        caretaker.saveState(editor);

        editor.addText(" How are you?");
        System.out.println("Current text: " + editor.getText());

        caretaker.undo(editor);
        System.out.println("After undo: " + editor.getText());
    }
}
