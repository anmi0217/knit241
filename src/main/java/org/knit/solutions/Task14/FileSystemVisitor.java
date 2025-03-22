package org.knit.solutions.Task14;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Folder folder);
    void visit(Link link);
}