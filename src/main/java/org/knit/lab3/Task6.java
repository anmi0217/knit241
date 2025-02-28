package org.knit.lab3;

import java.util.Objects;
import java.util.Scanner;

public class Task6 {
    public void execute() {
        WarriorGuard warriorGuard = new WarriorGuard("Щитовик");
        Mage mage = new Mage("Маг");
        Healer healer = new Healer("Хиллер");
        Warrior warrior = new Warrior("Воин");

        Scanner scanner = new Scanner(System.in);
        String command = "";
        int queue = 0;
        while (!Objects.equals(command, "exit")) {
            if (queue == 0) {
                System.out.println("Доступные команды: attack [name], move [x, y]");
                System.out.print("Воин>> ");
                command = scanner.nextLine();
                String[] commandsp = command.split(" ");
                if (Objects.equals(commandsp[0], "attack")) {
                    if (Objects.equals(commandsp[1], "Маг")) {
                        warrior.attack(mage);
                        System.out.println(mage);
                    } else if (Objects.equals(commandsp[1], "Хиллер")) {
                        warrior.attack(healer);
                        System.out.println(healer);
                    } else if (Objects.equals(commandsp[1], "Щитовик")) {
                        warrior.attack(warriorGuard);
                        System.out.println(warriorGuard);
                    } else {
                        System.out.println("Такого класса нет!");
                    }
                } else if (Objects.equals(commandsp[0], "move")) {
                    warrior.move(Integer.parseInt(commandsp[1]), Integer.parseInt(commandsp[2]));
                }
                queue = 1;
            } else if (queue == 1) {
                System.out.println("Доступные команды: cast [name], move [x, y]");
                System.out.print("Маг>> ");
                command = scanner.nextLine();
                String[] commandsp = command.split(" ");
                if (Objects.equals(commandsp[0], "cast")) {
                    if (Objects.equals(commandsp[1], "Воин")) {
                        mage.castSpell(warrior);
                        System.out.println(warrior);
                    } else if (Objects.equals(commandsp[1], "Хиллер")) {
                        mage.castSpell(healer);
                        System.out.println(healer);
                    } else if (Objects.equals(commandsp[1], "Щитовик")) {
                        mage.castSpell(warriorGuard);
                        System.out.println(warriorGuard);
                    } else {
                        System.out.println("Такого класса нет!");
                    }
                } else if (Objects.equals(commandsp[0], "move")) {
                    warrior.move(Integer.parseInt(commandsp[1]), Integer.parseInt(commandsp[2]));
                }
                queue = 2;
            } else if (queue == 2) {
                System.out.println("Доступные команды: heal [name], move [x, y]");
                System.out.print("Хиллер>> ");
                command = scanner.nextLine();
                String[] commandsp = command.split(" ");
                if (Objects.equals(commandsp[0], "heal")) {
                    if (Objects.equals(commandsp[1], "Воин")) {
                        healer.heal(warrior);
                        System.out.println(warrior);
                    } else if (Objects.equals(commandsp[1], "Хиллер")) {
                        healer.heal(healer);
                        System.out.println(healer);
                    } else if (Objects.equals(commandsp[1], "Щитовик")) {
                        healer.heal(warriorGuard);
                        System.out.println(warriorGuard);
                    } else if (Objects.equals(commandsp[1], "Маг")) {
                        healer.heal(mage);
                        System.out.println(mage);
                    } else {
                        System.out.println("Такого класса нет!");
                    }
                } else if (Objects.equals(commandsp[0], "move")) {
                    warrior.move(Integer.parseInt(commandsp[1]), Integer.parseInt(commandsp[2]));
                }
                queue = 3;
            } else if (queue == 3) {
                System.out.println("Доступные команды: attack [name], shield [name], move [x, y]");
                System.out.print("Щитовик>> ");
                command = scanner.nextLine();
                String[] commandsp = command.split(" ");
                if (Objects.equals(commandsp[0], "shield")) {
                    if (Objects.equals(commandsp[1], "Воин")) {
                        warriorGuard.deployShield(warrior);
                        System.out.println(warrior);
                    } else if (Objects.equals(commandsp[1], "Хиллер")) {
                        warriorGuard.deployShield(healer);
                        System.out.println(healer);
                    } else if (Objects.equals(commandsp[1], "Щитовик")) {
                        warriorGuard.deployShield(warriorGuard);
                        System.out.println(warriorGuard);
                    } else if (Objects.equals(commandsp[1], "Маг")) {
                        warriorGuard.deployShield(mage);
                        System.out.println(mage);
                    } else {
                        System.out.println("Такого класса нет!");
                    }
                } else if (Objects.equals(commandsp[0], "move")) {
                    warrior.move(Integer.parseInt(commandsp[1]), Integer.parseInt(commandsp[2]));
                }
                queue = 0;
            }
        }
    }
}
