package org.knit.solutions.task39;

import java.util.HashSet;
import java.util.Set;

public class Task39 {
    public static void main(String[] args) {
        Set<FileSystemElement> fileSystem = new HashSet<>();

        FileSystemElement file1 = new File("file1", 100);
        FileSystemElement file2 = new File("file2", 200);
        FileSystemElement file3 = new File("file3", 300);
        FileSystemElement file4 = new File("file4", 400);

        Directory directory1 = new Directory("folder1");
        Directory directory2 = new Directory("folder2");

        FileSystemElement shortcut1 = new Shortcut("shortcut1", file1);
        FileSystemElement shortcut2 = new Shortcut("shortcut2", directory1);

        directory1.addElement(file1);
        directory1.addElement(file2);

        directory2.addElement(file3);
        directory2.addElement(shortcut1);

        fileSystem.add(directory1);
        fileSystem.add(directory2);
        fileSystem.add(file4);
        fileSystem.add(shortcut2);

        SizeAnalyser sizeAnalyser = new SizeAnalyser();
        Antivirus antivirus = new Antivirus();
        for (FileSystemElement element : fileSystem) {
            element.accept(sizeAnalyser);
            element.accept(antivirus);
        }
    }
}
