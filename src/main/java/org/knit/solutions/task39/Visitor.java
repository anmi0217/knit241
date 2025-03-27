package org.knit.solutions.task39;

public interface Visitor {
    void visit(File file);

    void visit(Directory directory);

    void visit(Shortcut shortcut);
}
