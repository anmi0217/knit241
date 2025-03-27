package org.knit.solutions.lab2_5.Task2_14Classes;

public class SizeAnalyzer implements Visitor{
    @Override
    public void visit(File file) {
        System.out.println("Размер файла " + file.getName() + " составляет " + file.getByteSize() + "Б");
    }

    @Override
    public void visit(Folder folder) {
        System.out.println("Размер папки " + folder.getName() + " составляет " + folder.getByteSize() + "Б. В ней: {");
        for (FileSystemElement el : folder.getContent()) {
            if (el instanceof File) {
                visit((File) el);
            } else if (el instanceof Folder) {
                visit((Folder) el);
            } else if (el instanceof Shortcut) {
                visit((Shortcut) el);
            }
        }
        System.out.println("}");
    }

    @Override
    public void visit(Shortcut shortcut) {
        System.out.println("Размер ссылки " + shortcut.getName() + " не показывается");
    }
}
