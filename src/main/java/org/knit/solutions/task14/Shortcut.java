package org.knit.solutions.task14;

public class Shortcut implements FileSystemElement {
    private final FileSystemElement target;

    public Shortcut(FileSystemElement target) {
        this.target = target;
    }

    public FileSystemElement getTarget() {
        return target;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}