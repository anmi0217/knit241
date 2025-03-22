package org.knit.solutions;

import org.knit.TaskDescription;

import java.util.Random;

/*
📌 Описание:
Парадокс Монти Холла — это задача из теории вероятностей, основанная на популярном шоу "Let's Make a Deal".
Правила такие:

Участник выбирает одну из трёх дверей.
Ведущий, который знает, что за дверями, открывает одну из оставшихся дверей, за которой нет приза.
Участнику предлагается либо сменить выбор на оставшуюся дверь, либо оставить свой выбор неизменным.
📌 Вопрос:

Реализуйте симуляцию этой игры на Java, чтобы проверить, что лучше: менять выбор или оставаться при своём?.
Программа должна провести большое количество экспериментов (например, 1000000) и показать вероятность выигрыша в каждом из двух случаев.
📌 Ожидаемый результат:
При достаточно большом количестве игр (например, 1 миллион):

Вероятность выигрыша при переключении: около 66.66% (или 2/3).
Вероятность выигрыша без переключения: около 33.33% (или 1/3).
 */

@TaskDescription(taskNumber = 17, taskDescription = "Реализация и проверка парадокса Монти Холла")
public class Task17Solution implements Solution {
    @Override
    public void execute() {
        int experiments = 1_000_000;
        int winsWhenSwitching = 0;
        int winsWhenStaying = 0;

        Random random = new Random();

        for (int i = 0; i < experiments; i++) {
            int prizeDoor = random.nextInt(3);
            int playerChoice = random.nextInt(3);

            int montyDoor = -1;
            for (int door = 0; door < 3; door++) {
                if (door != playerChoice && door != prizeDoor) {
                    montyDoor = door;
                    break;
                }
            }
            if (playerChoice == prizeDoor) {
                int[] possibleDoors = new int[2];
                int index = 0;
                for (int door = 0; door < 3; door++) {
                    if (door != playerChoice) {
                        possibleDoors[index++] = door;
                    }
                }
                montyDoor = possibleDoors[random.nextInt(2)];
            }

            int switchedChoice = -1;
            for (int door = 0; door < 3; door++) {
                if (door != playerChoice && door != montyDoor) {
                    switchedChoice = door;
                    break;
                }
            }

            if (playerChoice == prizeDoor) {
                winsWhenStaying++;
            }
            if (switchedChoice == prizeDoor) {
                winsWhenSwitching++;
            }
        }

        System.out.println("Результаты после " + experiments + " игр:");
        System.out.println("Победа при оставлении выбора: " + winsWhenStaying + " ("
                + (100.0 * winsWhenStaying / experiments) + "%)");
        System.out.println("Победа при переключении: " + winsWhenSwitching + " ("
                + (100.0 * winsWhenSwitching / experiments) + "%)");
    }
}
