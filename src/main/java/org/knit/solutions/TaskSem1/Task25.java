package org.knit.solutions.TaskSem1;

import java.util.Scanner;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab11.Task25.*;

import org.knit.TaskDescription;

/**
 * Задача 25: Создание консольного приложения для сохранения файлов в базу данных
 * <p>
 * Описание:
 * 1. Приложение получает путь к файлу или папке от пользователя.
 * 2. Проверяет размер каждого файла (должен быть меньше 10 MB).
 * 3. Сохраняет файлы в таблицу базы данных в бинарном формате.
 * <p>
 * Требования:
 * - Использовать PostgreSQL (или другую СУБД) для хранения данных.
 * - Создать таблицу files с полями:
 * - id SERIAL PRIMARY KEY (уникальный идентификатор)
 * - file_name VARCHAR(255) NOT NULL (имя файла)
 * - file_binary BYTEA NOT NULL (бинарное содержимое файла)
 * <p>
 * Классы:
 * - DatabaseConnection (Singleton для управления подключением к БД).
 * - FileDAO (метод saveFile для сохранения файлов в БД).
 * - FileProcessor (обрабатывает файлы и передаёт их в FileDAO).
 * - FileApp (запрашивает путь у пользователя и запускает процесс обработки).
 */

@TaskDescription(taskNumber = 25,
        taskDescription = "Создание консольного приложения для сохранения файлов в базу данных",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task25 implements Solution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу или папке: ");
        String path = scanner.nextLine();

        FileProcessor processor = new FileProcessor();
        processor.processFiles(path);
    }
}

//CREATE TABLE files (
//        id SERIAL PRIMARY KEY,
//        file_name VARCHAR(255) NOT NULL,
//file_binary BYTEA NOT NULL
//);