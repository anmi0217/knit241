package org.knit.solutions.org2.lab17;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.util.Random;

@TaskDescription(
        taskNumber = 17,
        taskDescription = "Реализация и проверка парадокса Монти Холла"
)
public class Task17 implements Solution {
    private static final int TOTAL_DOORS = 3;
    private static final int TOTAL_GAMES = 1_000_000;
    private static final Random random = new Random();

    @Override
    public void execute() {
        int winWhenSwitch = 0;
        int winWhenStay = 0;

        for (int i = 0; i < TOTAL_GAMES; i++) {
            // Приз находится за случайной дверью (0, 1 или 2)
            int prizeDoor = random.nextInt(TOTAL_DOORS);

            // Участник выбирает случайную дверь
            int initialChoice = random.nextInt(TOTAL_DOORS);

            // Ведущий открывает дверь, которая не является выбранной и не содержит приз
            int openedDoor = getOpenedDoor(prizeDoor, initialChoice);

            // Участник решает не менять выбор
            if (initialChoice == prizeDoor) {
                winWhenStay++;
            }

            // Участник решает изменить выбор
            int switchedChoice = getSwitchedDoor(initialChoice, openedDoor);
            if (switchedChoice == prizeDoor) {
                winWhenSwitch++;
            }
        }

        // Вычисляем вероятности
        double stayWinRate = (double) winWhenStay / TOTAL_GAMES * 100;
        double switchWinRate = (double) winWhenSwitch / TOTAL_GAMES * 100;

        System.out.println("Результаты после " + TOTAL_GAMES + " игр:");
        System.out.printf("Вероятность выигрыша без смены выбора: %.2f%%\n", stayWinRate);
        System.out.printf("Вероятность выигрыша при смене выбора:  %.2f%%\n", switchWinRate);
    }

    private static int getOpenedDoor(int prizeDoor, int initialChoice) {
        int door;
        do {
            door = random.nextInt(TOTAL_DOORS);
        } while (door == prizeDoor || door == initialChoice);
        return door;
    }

    private static int getSwitchedDoor(int initialChoice, int openedDoor) {
        for (int i = 0; i < TOTAL_DOORS; i++) {
            if (i != initialChoice && i != openedDoor) {
                return i;
            }
        }
        return -1; // Не должно произойти при 3 дверях
    }
}