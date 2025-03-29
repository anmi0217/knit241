package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab9.Task17.User;
import org.knit.solutions.ClassesSem1.lab9.Task17.Validator;

import org.knit.TaskDescription;

/**
 * Задача 17: Валидация полей с помощью аннотаций
 * <p>
 * Описание:
 * 1. Создать аннотации для валидации значений полей в классе:
 * - @NotNull – проверяет, чтобы значение поля не было null.
 * - @MaxLength(int value) – проверяет, чтобы длина строки не превышала заданного значения.
 * - @Min(int value) – проверяет, чтобы числовое значение не было меньше заданного.
 * 2. Создать класс с полями, к которым применяются эти аннотации.
 * 3. Реализовать механизм проверки полей с использованием рефлексии.
 * <p>
 * Требования:
 * - Использовать пользовательские аннотации.
 * - Реализовать обработку аннотаций с помощью рефлексии.
 * - Вывести сообщения о нарушении ограничений, если они есть.
 */

@TaskDescription(taskNumber = 17,
        taskDescription = "Валидация полей с помощью аннотаций",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task17 implements Solution {
    public void execute() {
        try {
            User user = new User(null, "LongUsernameHere", 16);
            Validator.validate(user);
        } catch (IllegalAccessException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }
    }
}


