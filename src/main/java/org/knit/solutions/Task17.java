package org.knit.solutions;

import org.knit.TaskDescription;

import java.util.Random;

@TaskDescription(taskNumber = 17, taskDescription = "Задача 17: Реализация и проверка парадокса Монти Холла")
public class Task17 implements Solution{
    @Override
    public void execute() {
        int NUM_SIMULATIONS = 1_000_000;
        int winsWhenSwitching = 0;
        int winsWhenStaying = 0;

        Random random = new Random();

        for (int i = 0; i < NUM_SIMULATIONS; i++) {
            int prize = random.nextInt(3);
            int player = random.nextInt(3);

            int revealedDoor;
            do {
                revealedDoor = random.nextInt(3);
            } while (revealedDoor == prize || revealedDoor == player);

            int switchedChoice = 3 - player - revealedDoor;

            if (switchedChoice == prize) {
                winsWhenSwitching++;
            }
            if (player == prize) {
                winsWhenStaying++;
            }
        }

        System.out.println("Выигрыши при смене выбора: " + winsWhenSwitching + " (" + (winsWhenSwitching * 100.0 / NUM_SIMULATIONS) + "%)");
        System.out.println("Выигрыши без смены выбора: " + winsWhenStaying + " (" + (winsWhenStaying * 100.0 / NUM_SIMULATIONS) + "%)");
    }
}

