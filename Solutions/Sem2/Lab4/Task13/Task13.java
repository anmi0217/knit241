/*
Вы разрабатываете систему управления "умным домом", где пользователь может выполнять различные команды,
такие как включение/выключение света, управление телевизором и кондиционером.
 */

package org2.lab13;
import org2.annotations.Discription;
import java.util.Scanner;

@Discription(value = 13, name = "Реализация системы команд для управления умным домом")
public class Task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
