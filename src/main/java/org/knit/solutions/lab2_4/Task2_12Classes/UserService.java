package org.knit.solutions.lab2_4.Task2_12Classes;

import java.util.Scanner;

public class UserService {
    private CareTaker caretaker;
    private TextEditor relatedEditor;

    public UserService(TextEditor textEditor) {
        this.relatedEditor = textEditor;
        caretaker = new CareTaker(relatedEditor);
    }

    public void startEditing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вам предоставлен файл src/main/java/org/knit/jnbovfavhk/sem2/lab2_4/" + relatedEditor.getName());

        while (true) {
            System.out.println("Что вы хотите сделать?\n" +
                    "1. Записать что-то в файл\n" +
                    "2. Сохранить\n" +
                    "3. Вернуться к последней сохраненной версии файла\n" +
                    "4. Посмотреть содержимое\n" +
                    "5. Выйти");
            String ans = scanner.nextLine();
            switch (ans) {
                case "1":
                    System.out.println("Что пишем:");

                    String text = scanner.nextLine();
                    relatedEditor.editText(text);
                    System.out.println();
                    break;

                case "2":
                    caretaker.addSave();
                    System.out.println();
                    break;

                case "3":
                    caretaker.loadLastSave();
                    System.out.println();
                    break;

                case "4":
                    System.out.println(relatedEditor.getText());
                    System.out.println();
                    break;

                case "5":
                    return;

                default:
                    System.out.println("Вы ввели что-то некорректное");
                    break;
            }
        }
    }
}
