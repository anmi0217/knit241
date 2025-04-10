package org.knit.solutions.task39;

public class Shortcut implements FileSystemElement {
    private final String name;
    private final FileSystemElement element;

    public Shortcut(String name, FileSystemElement element) {
        this.name = name;
        this.element = element;
        System.out.printf("Создан ярлык %s элемента %s.\n", name, element.getName());
    }

    public FileSystemElement getElement() {
        return element;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isHasVirus() {
        return false;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
