package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task16.CharacterFactory;
import org.knit.solutions.task16.CharacterFlyweight;

/*
Задача:
Реализуйте систему отображения символов текста на экране.

Каждый символ (Character) имеет внутреннее состояние (код символа) и внешнее состояние (координаты x, y и стиль).
Используйте Фабрику приспособленцев, чтобы повторно использовать объекты символов и уменьшить количество объектов, создаваемых в системе.
📌 Подсказка:
Внешнее состояние передается в метод render(), а внутреннее хранится внутри объектов, создаваемых фабрикой.
 */

@TaskDescription(taskNumber = 16, taskDescription = "Задача 16 на паттерн Приспособленец (Flyweight)")
public class Task16 implements Solution{

    @Override
    public void execute() {
        CharacterFactory factory = new CharacterFactory();

        CharacterFlyweight a1 = factory.getCharacter('A');
        a1.render(10, 20, "bold");

        CharacterFlyweight a2 = factory.getCharacter('A');
        a2.render(30, 40, "italic");

        CharacterFlyweight b = factory.getCharacter('B');
        b.render(50, 60, "underline");

        System.out.println("Объекты символов в памяти: " + factory.characters.size());
    }
}
