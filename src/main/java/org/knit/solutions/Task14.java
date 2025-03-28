package org.knit.solutions;
import org.knit.TaskDescription;
import org.knit.solutions.task14.*;

/*
Задача:
Создайте систему управления файловыми объектами.
Есть три типа файловых объектов:

Файлы,
Папки,
Ссылки (ярлыки).
Требуется реализовать два посетителя:

Сканер вирусов, который проверяет каждый файл на наличие вирусов.
Анализатор размера, который подсчитывает общий размер файлов (ссылки не учитываются).
📌 Подсказка:
Каждый файл, папка и ссылка должны реализовывать интерфейс FileSystemElement. В accept() методе вызывается соответствующий метод визитера.
 */

@TaskDescription(taskNumber = 14, taskDescription = "14. Задача 14 на паттерн Визитер (Visitor)")
public class Task14 implements Solution{
    @Override
    public void execute(){
        File file1 = new File("file1.txt", 100, false);
        File file2 = new File("file2.exe", 200, true);
        File file3 = new File("file3.jpg", 300, false);

        Folder folder = new Folder("Documents");
        folder.addElement(file1);
        folder.addElement(file2);
        folder.addElement(file3);
        folder.addElement(new Shortcut(file2));

        VirusScanner scanner = new VirusScanner();
        SizeAnalyzer sizeAnalyzer = new SizeAnalyzer();

        System.out.println("Сканирование на вирусы:");
        folder.accept(scanner);

        System.out.println("\nАнализ размера:");
        folder.accept(sizeAnalyzer);
        System.out.println("Общий размер файлов: " + sizeAnalyzer.getTotalSize() + " байт");
    }
}
