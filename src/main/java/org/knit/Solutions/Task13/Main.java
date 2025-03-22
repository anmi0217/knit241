package org.knit.Solutions.Task13;

/*
3. Паттерн Command (Команда)
Задача 13: Реализация системы команд для управления умным домом

Вы разрабатываете систему управления "умным домом", где пользователь может выполнять различные команды, такие как включение/выключение света, управление телевизором и кондиционером.

Требуется:

Создать интерфейс Command, который определяет метод execute().
Реализовать классы команд:
LightOnCommand – включает свет.
LightOffCommand – выключает свет.
TVOnCommand – включает телевизор.
TVOffCommand – выключает телевизор.
Создать класс RemoteControl, который хранит команду и позволяет её выполнить.
Реализовать механизм отмены последней команды (undo).
Пример работы:

Пользователь нажимает кнопку "Включить свет" – выполняется LightOnCommand.
Затем нажимает "Выключить телевизор" – выполняется TVOffCommand.
Пользователь нажимает "Отменить последнюю команду" – телевизор снова включается.
Дополнительно: Реализуйте поддержку макрокоманд (например, кнопка "Спокойной ночи" выключает все приборы разом).
 */

import org.knit.Solutions.TasksDescripton;


public class Main {
    @TasksDescripton(number = 13, name = "3. Паттерн Command (Команда)")
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        TV tv = new TV();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command tvOn = new TVOnCommand(tv);
        Command tvOff = new TVOffCommand(tv);

        remote.execute(lightOn);
        remote.execute(lightOff);
        remote.execute(tvOn);
        remote.execute(tvOff);
        System.out.println();
        remote.undo();
        remote.undo();
        remote.undo();
        remote.undo();
        remote.undo();
        System.out.println();
        remote.goodNight(light, tv);
        System.out.println();
        remote.goodMorning(light, tv);
    }
}
