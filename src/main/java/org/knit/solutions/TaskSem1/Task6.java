package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab3.Player;
import org.knit.solutions.ClassesSem1.lab3.Warrior;
import org.knit.solutions.ClassesSem1.lab3.Mage;
import org.knit.solutions.ClassesSem1.lab3.Priest;
import org.knit.solutions.ClassesSem1.lab3.Game;

import java.util.Scanner;

import org.knit.TaskDescription;

/***
 * Задача 6
 * Смоделировать персонажей классической 2D RPG
 *
 * Создайте общий класс Player с полями:
 * - Имя
 * - Текущее здоровье
 * - Максимальное здоровье
 * - Статус (жив/мертв)
 * - Позиция (X, Y)
 * - Урон
 * - Защита
 *
 * Реализуйте методы:
 * - увеличить здоровье
 * - уменьшить здоровье
 * - подвинуться на позицию (X, Y)
 *
 * Создайте подклассы:
 * - Mage (маг) — умеет бросать атакующее заклинание
 * - Priest (священник) — умеет лечить других игроков
 * - Warrior (воин) — умеет атаковать
 * - Guard (гвардеец, подтип воина) — имеет дополнительную защиту
 *
 * Используйте интерфейсы для магии, лечения и атаки.
 * Переопределите метод toString() для вывода информации о персонажах.
 */

@TaskDescription(taskNumber = 6,
        taskDescription = "Смоделировать персонажей классической 2d RPG",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task6 implements Solution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        printRules();

        // Создаем персонажей
        Player[] player1Characters = {
                new Warrior("Орк Игрока 1", -5, 0),
                new Mage("Маг Игрока 1", -10, 10),
                new Priest("Священник Игрока 1", -10, -10)
        };

        Player[] player2Characters = {
                new Warrior("Орк Игрока 2", 5, 0),
                new Mage("Маг Игрока 2", 10, 10),
                new Priest("Священник Игрока 2", 10, -10)
        };

        // Запуск игры
        Game game = new Game(player1Characters, player2Characters, scanner);
        game.start();

        scanner.close();
    }

    public static void printRules() {
        System.out.println("Правила игры:");
        System.out.println("1. У каждого игрока есть три персонажа: Орк, Маг и Священник.");
        System.out.println("2. Каждый персонаж имеет свои индивидуальные характеристики:");
        System.out.println("   - Орк обладает дополнительной защитой.");
        System.out.println("   - Маг владеет мощной атакой магией.");
        System.out.println("   - Священник может восстанавливать здоровье.");
        System.out.println("3. Для передвижения нужно ввести координаты.");
        System.out.println("   Персонаж может перемещаться на любую клетку, если у него достаточно энергии.");
        System.out.println("   Каждое перемещение на одну клетку требует 1 единицу энергии.");
        System.out.println("4. Энергия также требуется для других действий, таких как атака или использование специальных способностей.");
        System.out.println("5. Каждый ход всем персонажам игрока добавляется 20 единиц энергии.");
        System.out.println("6. Цель игры — уничтожить всех вражеских персонажей.");
        System.out.println("7. После каждого хода энергия персонажей восполняется, но максимальный её уровень не может быть превышен.");
    }
}
