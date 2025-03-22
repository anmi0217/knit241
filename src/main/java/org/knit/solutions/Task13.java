/*
Вы разрабатываете систему управления "умным домом", где пользователь может выполнять различные команды,
такие как включение/выключение света, управление телевизором и кондиционером.
 */

package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.org2.lab13.*;

import java.util.Scanner;

@TaskDescription(taskNumber = 13, taskDescription = "Паттерн Command (Команда) ...")
public class Task13 implements Solution
{

    @Override
    public void execute() { Scanner scanner = new Scanner(System.in);
        RemoteControl remoteControl = new RemoteControl(); // Создаем пульт
        Light light = new Light(); // Создаем свет
        TV tv = new TV(); // Создаем телевизор

        // Создаем команды
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command tvOn = new TVOnCommand(tv);
        Command tvOff = new TVOffCommand(tv);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Включить свет");
            System.out.println("2. Выключить свет");
            System.out.println("3. Включить телевизор");
            System.out.println("4. Выключить телевизор");
            System.out.println("5. Отменить последнюю команду");
            System.out.println("6. Выйти");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    remoteControl.executeCommand(lightOn);
                    break;
                case 2:
                    remoteControl.executeCommand(lightOff);
                    break;
                case 3:
                    remoteControl.executeCommand(tvOn);
                    break;
                case 4:
                    remoteControl.executeCommand(tvOff);
                    break;
                case 5:
                    remoteControl.undoLastCommand();
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

    }
}


