package org.knit.solutions.org2.lab14;

public class SizeAnalyzer implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Folder folder) {
        // Папки не учитываются в общем размере
    }

    @Override
    public void visit(Link link) {
        // Ссылки не учитываются в общем размере
    }

    public int getTotalSize() {
        return totalSize;
    }
}
