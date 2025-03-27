package org.knit.solutions.task39;

import java.util.HashSet;
import java.util.Set;

public class Directory implements FileSystemElement {
    private final String name;
    private final Set<FileSystemElement> elements = new HashSet<>();

    public Directory(String name) {
        this.name = name;
        System.out.printf("Создана папка %s.\n", name);
    }

    public void addElement(FileSystemElement element) {
        if (elements.contains(element)) {
            System.out.printf("В папке %s уже существует элемент %s.\n", getName(), element.getName());
        } else {
            elements.add(element);
            System.out.printf("В папку %s добавлен элемент %s.\n", getName(), element.getName());
        }
    }

    public void removeElement(FileSystemElement element) {
        if (elements.contains(element)) {
            elements.remove(element);
            System.out.printf("Из папки %s удалён элемент %s.\n", getName(), element.getName());
        } else {
            System.out.printf("В папке %s отсутствует элемент %s.\n", getName(), element.getName());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (FileSystemElement element : elements) {
            size += element.getSize();
        }
        return size;
    }

    @Override
    public boolean isHasVirus() {
        for (FileSystemElement element : elements) {
            if (element.isHasVirus()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
