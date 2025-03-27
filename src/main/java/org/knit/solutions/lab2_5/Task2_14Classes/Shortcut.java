package org.knit.solutions.lab2_5.Task2_14Classes;

public class Shortcut implements FileSystemElement{
    private FileSystemElement target;
    private String name;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getByteSize() {
        return name.length() * 2 + target.getByteSize();
    }

    public FileSystemElement getTarget() {
        return target;
    }

    public String getName() {
        return name;
    }

    public Shortcut(String name, FileSystemElement target) {
        this.target = target;
        this.name = name;
    }
}
