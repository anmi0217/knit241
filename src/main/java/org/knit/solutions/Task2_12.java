package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.lab2_4.Task2_12Classes.CareTaker;
import org.knit.solutions.lab2_4.Task2_12Classes.TextEditor;
import org.knit.solutions.lab2_4.Task2_12Classes.UserService;

@TaskDescription(taskNumber = 12, taskDescription = "Паттерн Memento (Хранитель). " +
        "Разработайте систему, позволяющую сохранять состояния текста в редакторе и откатывать изменения назад.", href = "org/knit/solutions/lab2_4/Task2_12Classes")
public class Task2_12 implements Solution{
    public void execute() {

        TextEditor textEditor = new TextEditor("src/main/java/org/knit/solutions/lab2_4/Task2_12Classes/Text.txt");
        CareTaker careTaker = new CareTaker(textEditor);

        careTaker.addSave();

        textEditor.editText("iouuthrogviu owihgg owiegh koqpo olhee");
        careTaker.addSave();

        textEditor.editText("еще один текст");
        careTaker.addSave();

        textEditor.editText("jsdfug");
        careTaker.addSave();

        textEditor.editText("erfiuherfiouhwerfwerfwerfwergwrgdfsgsdgwregf");
        careTaker.addSave();

        textEditor.editText("последний");
        careTaker.loadLastSave();
        careTaker.loadLastSave();
        careTaker.loadLastSave();


        TextEditor textEditor2 = new TextEditor("src/main/java/org/knit/solutions/lab2_4/Task2_12Classes/Text2.txt");
        UserService userService = new UserService(textEditor2);
        userService.startEditing();



    }
}
