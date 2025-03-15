package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task13.*;

/*
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

@TaskDescription(taskNumber = 13, taskDescription = "Паттерн Command (Команда)")
public class Task13Solution implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 13 запущена");

        Light livingRoomLight = new Light("гостиной");
        TV livingRoomTV = new TV("гостиной");
        AirConditioner livingRoomAC = new AirConditioner("гостиной");

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command tvOn = new TVOnCommand(livingRoomTV);
        Command tvOff = new TVOffCommand(livingRoomTV);
        Command acOn = new AirConditionerOnCommand(livingRoomAC);
        Command acOff = new AirConditionerOffCommand(livingRoomAC);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(tvOff);
        remote.pressButton();

        System.out.println("Отмена последней команды:");
        remote.pressUndo();

        Command[] goodNightCommands = { lightOff, tvOff, acOff };
        Command goodNightMacro = new MacroCommand(goodNightCommands);
        remote.setCommand(goodNightMacro);
        System.out.println("Выполнение макрокоманды 'Спокойной ночи':");
        remote.pressButton();

        System.out.println("Отмена макрокоманды 'Спокойной ночи':");
        remote.pressUndo();
    }
}
