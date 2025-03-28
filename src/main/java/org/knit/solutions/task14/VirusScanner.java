package org.knit.solutions.task14;

public class VirusScanner implements FileSystemVisitor {
    @Override
    public void visit(File file) {
        if (file.hasVirus()) {
            System.out.println("Вирус обнаружен в файле: " + file.getName());
        } else {
            System.out.println("Файл безопасен: " + file.getName());
        }
    }

    @Override
    public void visit(Folder folder) {
        for (FileSystemElement element : folder.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Shortcut shortcut) {
        System.out.println("Пропущена проверка ярлыка.");
    }
}