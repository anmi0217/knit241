package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_5.Task2_14Classes.*;

@TaskDescription(taskNumber = 14, taskDescription = "Создайте систему управления файловыми объектами. " +
        "Требуется создать посетители: сканер вирусов и анализатор размера",
        href = "org/knit/solutions/lab2_5/Task2_14Classes")
public class Task2_14 implements Solution{
    @Override
    public void execute() throws ClassNotFoundException, InterruptedException {
        File file1 = new File("file1", "gyucuywfdvirusgeds");
        File file2 = new File("file2", "qwerty");
        File file3 = new File("file3");
        Folder folder1 = new Folder("folder1");
        Folder folder2 = new Folder("folder2");
        Shortcut shortcut = new Shortcut("shortcutToFile2", file2);


        folder1.add(file1);
        folder1.add(file2);
        folder1.add(folder2);
        folder1.add(shortcut);
        folder2.add(file3);

        VirusScanner virusScanner = new VirusScanner();
        SizeAnalyzer sizeAnalyzer = new SizeAnalyzer();

        folder1.accept(virusScanner);
        for (FileSystemElement el : folder1.getContent()) {
            el.accept(sizeAnalyzer);
        }
    }
}
