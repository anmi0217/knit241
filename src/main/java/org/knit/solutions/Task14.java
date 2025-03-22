package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.org2.lab14.*;


@TaskDescription(taskNumber = 14, taskDescription = "Визитер (Visitor)")
public class Task14 implements Solution
{
    @Override
    public void execute() {
        // Создаем файловую систему
        Folder root = new Folder("Root");

        File file1 = new File("file1.txt", 100, false);
        File file2 = new File("file2.exe", 200, true);
        Folder folder1 = new Folder("Folder1");
        File file3 = new File("file3.doc", 300, false);
        Link link1 = new Link("link1", file1);

        folder1.addElement(file3);
        root.addElement(file1);
        root.addElement(file2);
        root.addElement(folder1);
        root.addElement(link1);

        // Создаем посетителей
        VirusScanner virusScanner = new VirusScanner();
        SizeAnalyzer sizeAnalyzer = new SizeAnalyzer();

        // Применяем посетителей к файловой системе
        root.accept(virusScanner);
        root.accept(sizeAnalyzer);

        // Выводим результаты
        System.out.println("Общий размер файлов: " + sizeAnalyzer.getTotalSize() + " байт");
    }
}
