package org.knit.solutions.task39;

public class SizeAnalyser implements Visitor {
    @Override
    public void visit(File file) {
        System.out.printf("Размер файла %s составляет %d байт.\n", file.getName(), file.getSize());
    }

    @Override
    public void visit(Directory directory) {
        System.out.printf("Размер папки %s составляет %d байт.\n", directory.getName(), directory.getSize());
    }

    @Override
    public void visit(Shortcut shortcut) {
        System.out.printf("Размер ярлыка %s составляет %d байт.\n", shortcut.getName(), shortcut.getSize());
    }
}
