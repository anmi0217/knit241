package org.knit.solutions.task14;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Folder folder);
    void visit(Shortcut shortcut);
}
