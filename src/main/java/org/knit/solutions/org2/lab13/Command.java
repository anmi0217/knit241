package org.knit.solutions.org2.lab13;

interface Command {
    void execute(); // Метод для выполнения команды
    void undo();    // Метод для отмены команды
}
