package org.knit.solutions.Task14;

public class SizeAnalyzer implements FileSystemVisitor {
    private int totalSize = 0;

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Folder folder) {
        for (FileSystemElement element : folder.getChildren()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Link link) {
    }
}
