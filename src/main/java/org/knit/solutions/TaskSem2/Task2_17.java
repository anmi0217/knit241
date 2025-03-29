package org.knit.solutions.TaskSem2;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

import java.util.Random;

/**
 * Задача 17: Реализация и проверка парадокса Монти Холла
 * <p>
 * Описание:
 * - Участник выбирает одну из трёх дверей.
 * - Ведущий открывает одну из оставшихся дверей, за которой нет приза.
 * - Участник может либо сменить выбор, либо оставить его неизменным.
 * <p>
 * Требования:
 * - Реализовать симуляцию игры на Java.
 * - Провести большое количество экспериментов (например, 1 000 000).
 * - Подсчитать вероятность выигрыша в каждом из двух случаев.
 * <p>
 * Ожидаемый результат:
 * - Вероятность выигрыша при смене выбора ≈ 66.66% (2/3).
 * - Вероятность выигрыша без смены ≈ 33.33% (1/3).
 */


@TaskDescription(taskNumber = 17,
        taskDescription = "Реализация и проверка парадокса Монти Холла",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_17 implements Solution {
    private static final int NUM_SIMULATIONS = 1_000_000;

    public void execute() {
        Random random = new Random();

        int winsIfSwitch = 0;
        int winsIfStay = 0;

        for (int i = 0; i < NUM_SIMULATIONS; i++) {
            int prizeDoor = random.nextInt(3);  // За какой дверью приз
            int playerChoice = random.nextInt(3);  // Игрок выбирает случайную дверь

            // Ведущий открывает дверь без приза и не совпадающую с выбором игрока
            int revealedDoor;
            do {
                revealedDoor = random.nextInt(3);
            } while (revealedDoor == prizeDoor || revealedDoor == playerChoice);

            // Если игрок меняет выбор
            int remainingDoor = 3 - playerChoice - revealedDoor;
            if (remainingDoor == prizeDoor) {
                winsIfSwitch++;
            }

            // Если игрок остаётся при своём выборе
            if (playerChoice == prizeDoor) {
                winsIfStay++;
            }
        }

        System.out.printf("Шанс выигрыша при смене выбора: %.2f%%%n", (winsIfSwitch / (double) NUM_SIMULATIONS) * 100);
        System.out.printf("Шанс выигрыша при оставлении: %.2f%%%n", (winsIfStay / (double) NUM_SIMULATIONS) * 100);
    }
}

