package org.knit.solutions.org2.lab14;

class VirusScanner implements FileSystemVisitor {
    @Override
    public void visit(File file) {
        if (file.isInfected()) {
            System.out.println("Вирус обнаружен в файле: " + file.getName());
        } else {
            System.out.println("Файл " + file.getName() + " чист.");
        }
    }

    @Override
    public void visit(Folder folder) {
        System.out.println("Сканирование папки: " + folder.getClass().getSimpleName());
    }

    @Override
    public void visit(Link link) {
        System.out.println("Ссылка " + link.getClass().getSimpleName() + " пропущена.");
    }
}