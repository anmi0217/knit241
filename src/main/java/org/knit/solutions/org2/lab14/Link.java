package org.knit.solutions.org2.lab14;

class Link implements FileSystemElement {
    private String name;
    private FileSystemElement target;

    public Link(String name, FileSystemElement target) {
        this.name = name;
        this.target = target;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}