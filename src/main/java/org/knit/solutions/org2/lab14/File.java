package org.knit.solutions.org2.lab14;

public class File implements FileSystemElement {
    private String name;
    private int size;
    private boolean isInfected; // Флаг, указывающий на наличие вируса

    public File(String name, int size, boolean isInfected) {
        this.name = name;
        this.size = size;
        this.isInfected = isInfected;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean isInfected() {
        return isInfected;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}