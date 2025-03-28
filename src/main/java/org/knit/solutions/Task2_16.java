package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.lab2_5.Task2_16Classes.Character;
import org.knit.solutions.lab2_5.Task2_16Classes.CharacterFactory;
import org.knit.solutions.lab2_5.Task2_16Classes.FlyWeight;

@TaskDescription(taskNumber = 16, taskDescription = "Flyweight. Реализуйте систему отображения символов текста на экране. " +
        "Каждый символ (Character) имеет внутреннее состояние (код символа) и внешнее состояние (координаты x, y и стиль).",
href = "org/knit/solutions/lab2_5/Task2_16Classes")

public class Task2_16 implements Solution{
    @Override
    public void execute() throws ClassNotFoundException, InterruptedException {
        CharacterFactory charFactory = new CharacterFactory();
        FlyWeight char1 = charFactory.getChar(1);
        char1.render(3, 4, "Times New Roman");

        FlyWeight char2 = charFactory.getChar(2);
        char2.render(1, 10, "Arial");

        FlyWeight char3 = charFactory.getChar(1);
        char3.render(1, 6, "comic sans");

        FlyWeight char4 = charFactory.getChar(2);
        char4.render(1, 0, "Amazone");
    }
}
