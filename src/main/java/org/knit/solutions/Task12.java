/*
Разработайте систему, позволяющую сохранять состояния текста в редакторе и откатывать изменения назад.
 */

package org.knit.solutions;

import org.knit.solutions.annotations.Discription;
import org.knit.TaskDescription;
import org.knit.solutions.org2.lab12.*;
import org.knit.solutions.org2.lab12.Caretaker;
import org.knit.solutions.org2.lab12.TextEditor;
import org.knit.solutions.org2.lab12.TextMemento;

import java.util.Scanner;

@TaskDescription(taskNumber = 12, taskDescription = "Реализация системы отмены изменений в текстовом редакторе")
public class Task12 implements Solution
{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor(); // Создаем текстовый редактор
        Caretaker caretaker = new Caretaker(); // Создаем управляющего историей

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить текст");
            System.out.println("2. Сохранить текущее состояние");
            System.out.println("3. Отменить последнее изменение");
            System.out.println("4. Выйти");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите текст для добавления: ");
                    String newText = scanner.nextLine();
                    editor.addText(newText);
                    break;
                case 2:
                    caretaker.saveState(editor.saveState());
                    break;
                case 3:
                    TextMemento previousState = caretaker.undo();
                    if (previousState != null) {
                        editor.restoreState(previousState);
                    } else {
                        System.out.println("Нет сохраненных состояний для отмены.");
                    }
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
