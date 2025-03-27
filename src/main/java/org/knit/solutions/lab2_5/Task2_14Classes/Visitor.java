package org.knit.solutions.lab2_5.Task2_14Classes;

interface Visitor {
    void visit(File file);
    void visit(Folder folder);
    void visit(Shortcut shortcut);
}
