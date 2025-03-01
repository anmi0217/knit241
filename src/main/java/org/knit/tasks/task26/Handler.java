package org.knit.tasks.task26;

public abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void acceptProblem(Problem problem) {
        if (isCanHandleProblem(problem)) {
            handle(problem);
        } else if (nextHandler != null) {
            nextHandler.acceptProblem(problem);
        } else {
            System.out.println("Невозможно обработать проблему. " + problem);
        }
    }

    protected abstract boolean isCanHandleProblem(Problem problem);
    protected abstract void handle(Problem problem);
}
