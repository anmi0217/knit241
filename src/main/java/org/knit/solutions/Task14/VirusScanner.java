package org.knit.solutions.Task14;

public class VirusScanner implements FileSystemVisitor {

    @Override
    public void visit(File file) {
        System.out.println("Сканирование файла: " + file.getName());
        if (file.isInfected()) {
            System.out.println("Вирус обнаружен в файле: " + file.getName());
        } else {
            System.out.println("Файл " + file.getName() + " чист.");
        }
    }

    @Override
    public void visit(Folder folder) {
        System.out.println("Вход в папку: " + folder.getName());
        for (FileSystemElement element : folder.getChildren()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Link link) {
        System.out.println("Обработка ссылки: " + link.getName());

    }
}
