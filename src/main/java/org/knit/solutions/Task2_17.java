package org.knit.solutions;

import org.knit.TaskDescription;

import java.util.Random;

@TaskDescription(taskNumber = 17, taskDescription = "Реализуйте симуляцию парадокса монти холла на Java, " +
        "чтобы проверить, что лучше: менять выбор или оставаться при своём?.")
public class Task2_17 implements Solution{

    @Override
    public void execute() throws ClassNotFoundException, InterruptedException {
        Random random = new Random();

        int switchedWins = 0;
        int stayedWins = 0;

        for (int i = 0; i < 1000000; i++) {
            int prizeDoor = random.nextInt(3);

            int chosenDoor = random.nextInt(3);

            int openedByHost = random.nextInt(3);
            while (openedByHost == prizeDoor || openedByHost == chosenDoor) {
                openedByHost = random.nextInt(3);
            }

            boolean playerSwitchedChoice = random.nextBoolean();

            if (playerSwitchedChoice) {
                int switchedChoice = 3 - chosenDoor - openedByHost;
                if (switchedChoice == prizeDoor) {
                    switchedWins++;
                }
            } else {
                if (chosenDoor == prizeDoor) {
                    stayedWins++;
                }
            }
        }

        System.out.println("Игроков, выигравших при смене выбора - " + switchedWins);
        System.out.println("Игроков, выигравших и не менявших выбор - " + stayedWins);

        System.out.println("В процентном соотношении от всех выигравших:\n" +
                "Сменивших и выигравших: " + String.format("%.2f", (double)switchedWins / (stayedWins + switchedWins)) +
                "\nНе менявших и выигравших: " + String.format("%.2f", (double)stayedWins / (stayedWins + switchedWins)));
    }
}
