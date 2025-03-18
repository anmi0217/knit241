package org2.lab13;

import java.util.Stack;

// управление пультом
class RemoteControl {
    private Stack<Command> history = new Stack<>(); // История выполненных команд

    public void executeCommand(Command command) {
        command.execute();
        history.push(command); // Добавляем команду в историю
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop(); // Извлекаем последнюю команду
            lastCommand.undo(); // Отменяем её
        } else {
            System.out.println("Нет команд для отмены.");
        }
    }
}