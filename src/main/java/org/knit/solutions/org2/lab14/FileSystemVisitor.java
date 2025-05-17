package org.knit.solutions.org2.lab14;

interface FileSystemVisitor {
    void visit(File file);
    void visit(Folder folder);
    void visit(Link link);
}
