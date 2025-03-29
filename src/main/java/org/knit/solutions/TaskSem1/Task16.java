package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab9.Task16.Rank;
import org.knit.solutions.ClassesSem1.lab9.Task16.Suit;

import java.util.ArrayList;
import java.util.List;

import org.knit.TaskDescription;

/**
 * Задача 16: Карты колоды
 * <p>
 * Описание:
 * 1. Создать два Enum:
 * - Suit (масти карт: Пики, Черви, Бубны, Трефы).
 * - Rank (значения карт: 2-10, Валет, Дама, Король, Туз).
 * 2. Сгенерировать стандартную 52-карточную колоду, используя комбинации мастей и значений.
 * 3. Вывести сгенерированную колоду карт.
 * <p>
 * Требования:
 * - Использовать Enum для представления мастей и значений карт.
 * - Создать класс, представляющий карту, с полями Suit и Rank.
 * - Реализовать генерацию и вывод всех карт в колоде.
 */

@TaskDescription(taskNumber = 16,
        taskDescription = "Карты колоды",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task16 implements Solution {
    public void execute() {
        List<String> deck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(rank + " " + suit);
            }
        }

        System.out.println("Колода: ");
        for (String card : deck) {
            System.out.println(card);
        }
    }
}

