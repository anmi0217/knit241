package org.knit.solutions.task39;

public class Antivirus implements Visitor {
    @Override
    public void visit(File file) {
        if (file.isHasVirus()) {
            System.out.printf("Файл %s содержит вирусы.\n", file.getName());
        } else {
            System.out.printf("Файл %s не содержит вирусов.\n", file.getName());
        }
    }

    @Override
    public void visit(Directory directory) {
        if (directory.isHasVirus()) {
            System.out.printf("Папка %s содержит вирусы.\n", directory.getName());
        } else {
            System.out.printf("Папка %s не содержит вирусов.\n", directory.getName());
        }
    }

    @Override
    public void visit(Shortcut shortcut) {
        if (shortcut.getElement().isHasVirus()) {
            System.out.printf(
                    "Элемент %s, на который ссылается ярлык %s, содержит вирусы.\n",
                    shortcut.getElement().getName(), shortcut.getName()
            );
        } else {
            System.out.printf(
                    "Элемент %s, на который ссылается ярлык %s, не содержит вирусов.\n",
                    shortcut.getElement().getName(), shortcut.getName()
            );
        }
    }
}
