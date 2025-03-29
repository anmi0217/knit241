package org.knit.solutions.TaskSem1;

import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab2.Task5.File;
import org.knit.solutions.ClassesSem1.lab2.Task5.FileSystemComponent;
import org.knit.solutions.ClassesSem1.lab2.Task5.Folder;

import org.knit.TaskDescription;

/***
 * Задача 5
 * Реализация файловой системы с использованием паттерна Компоновщик
 *
 * Создайте интерфейс FileSystemComponent с методами:
 * - getName() — получить имя элемента
 * - getSize() — получить размер элемента
 * - add(FileSystemComponent component) — добавить элемент в папку (опционально)
 * - remove(FileSystemComponent component) — удалить элемент из папки (опционально)
 * - display(String indent) — вывести структуру файловой системы
 *
 * Реализуйте класс File:
 * - Имеет имя и размер
 * - Реализует getName() и getSize()
 * - Не поддерживает add() и remove()
 *
 * Реализуйте класс Folder:
 * - Может содержать файлы и папки
 * - Размер папки — сумма размеров всех элементов внутри неё
 * - Реализует методы getName(), getSize(), add(), remove(), display()
 */


@TaskDescription(taskNumber = 5,
        taskDescription = "Реализация файловой системы с использованием паттерна Компоновщик",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task5 implements Solution {
    public void execute() {
        // Создаем файлы
        FileSystemComponent file1 = new File("file1.txt", 100);
        FileSystemComponent file2 = new File("file2.txt", 200);
        FileSystemComponent file3 = new File("file3.txt", 300);

        // Создаем папки
        FileSystemComponent folder1 = new Folder("Folder1");
        FileSystemComponent folder2 = new Folder("Folder2");

        // Добавляем файлы в папки
        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);
        folder2.add(folder1); // Вложенная папка

        // Выводим структуру файловой системы
        folder2.display("");

        // Выводим общий размер папки 2
        System.out.println("Total size of Folder2: " + folder2.getSize() + " bytes");
    }
}

