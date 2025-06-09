package org.knit.solutions.org.lab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание персонажей
        Warrior warrior = new Warrior("Воин1");
        Priest priest = new Priest("Священник1");
        Mage mage = new Mage("Маг1");
        StrongEnemy enemy = new StrongEnemy("Враг");

        // Главный игровой цикл
        while (enemy.getCurrentHealth() > 0) {
            System.out.println("\nВыберите персонажа: ");
            System.out.println("1. Воин");
            System.out.println("2. Священник");
            System.out.println("3. Маг");
            int choice = scanner.nextInt();

            Player selectedPlayer = null;
            switch (choice) {
                case 1:
                    selectedPlayer = warrior;

                    break;
                case 2:
                    selectedPlayer = priest;
                    break;
                case 3:
                    selectedPlayer = mage;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    continue;
            }

            System.out.println("Выберите действие: ");
            System.out.println("1. Атаковать врага");
            System.out.println("2. Лечить (если выбран священник)");
            int action = scanner.nextInt();

            if (action == 1) {
                if (selectedPlayer instanceof Mage) {
                    mage.attack(enemy);
                } else if (selectedPlayer instanceof Warrior) {
                    warrior.attack(enemy);
                } else if (selectedPlayer instanceof Priest) {
                    // Если выбран священник, он может лечить себя или другого игрока
                    System.out.println("Выберите игрока для лечения:");
                    System.out.println("1. Воин");
                    System.out.println("2. Маг");
                    int healTarget = scanner.nextInt();
                    if (healTarget == 1) {
                        priest.heal(warrior);
                    } else if (healTarget == 2) {
                        priest.heal(mage);
                    } else {
                        System.out.println("Неверный выбор.");
                    }
                }
            } else if (action == 2 && selectedPlayer instanceof Priest) {
                // Если священник, он может лечить
                System.out.println("Выберите игрока для лечения:");
                System.out.println("1. Воин");
                System.out.println("2. Маг");
                int healTarget = scanner.nextInt();
                if (healTarget == 1) {
                    priest.heal(warrior);
                } else if (healTarget == 2) {
                    priest.heal(mage);
                } else {
                    System.out.println("Неверный выбор.");
                }
            }

            // Проверка состояния врага
            if (enemy.getCurrentHealth() <= 0) {
                System.out.println("Поздравляем! Вы победили " + enemy.getName() + "!");
                break;
            }

            // Враг атакует
            enemy.attack(selectedPlayer);
            // Проверка состояния игрока
            if (selectedPlayer.getCurrentHealth() <= 0) {
                System.out.println(selectedPlayer.getName() + " был побежден.");
            }
        }

        scanner.close();
    }
}
