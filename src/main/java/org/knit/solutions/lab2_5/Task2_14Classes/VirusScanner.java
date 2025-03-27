package org.knit.solutions.lab2_5.Task2_14Classes;

public class VirusScanner implements Visitor{

    @Override
    public void visit(File file) {
        if (file.getTextContent().contains("virus")) {
            System.out.println("!!! Обнаружен вирус в файле " + file.getName() + ". Сделайте что-нибудь с этим");
        } else {
            System.out.println("Файл " + file.getName() + " проверен и не содержит вирусов");
        }
    }

    @Override
    public void visit(Folder folder) {
        System.out.println("Папка " + folder.getName() + " проходит проверку...");
        for (FileSystemElement el : folder.getContent()) {
            if (el instanceof File) {
                visit((File) el);
            } else if (el instanceof Folder) {
                visit((Folder) el);
            } else if (el instanceof Shortcut) {
                visit((Shortcut) el);
            }
        }
        System.out.println("Проверка папки " + folder.getName() + " завершена");
    }

    @Override
    public void visit(Shortcut shortcut) {
        if (shortcut.getTarget() instanceof File) {
            visit((File) shortcut.getTarget());
        } else if (shortcut.getTarget() instanceof Folder) {
            visit((Folder) shortcut.getTarget());
        }
    }
}
