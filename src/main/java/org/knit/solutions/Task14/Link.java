package org.knit.solutions.Task14;

public class Link implements FileSystemElement {
    private final String name;
    private final FileSystemElement target;

    public Link(String name, FileSystemElement target) {
        this.name = name;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public FileSystemElement getTarget() {
        return target;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
