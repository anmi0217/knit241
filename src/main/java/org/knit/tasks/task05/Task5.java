package org.knit.tasks.task05;

public class Task5 {
    public static void main(String[] args) {
        Component file1 = new File("file1.txt", 100);
        Component file2 = new File("file2.txt", 200);
        Component file3 = new File("file3.txt", 300);
        Component file4 = new File("file4.txt", 400);

        Component folder1 = new Folder("folder1");
        Component folder2 = new Folder("folder2");
        Component folder3 = new Folder("folder3");

        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);

        folder3.add(file4);
        folder3.add(folder1);
        folder3.add(folder2);

        folder3.remove(folder2);

        folder3.print(0);

        System.out.printf("\n%s total size: %d bytes\n", folder3.getName(), folder3.getSize());
    }
}
