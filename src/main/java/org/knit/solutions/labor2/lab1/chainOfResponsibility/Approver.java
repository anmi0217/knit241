package org.knit.solutions.labor2.lab1.chainOfResponsibility;

public abstract class Approver {
    protected Approver nextApprover; // Следующий обработчик в цепочке

    public void setNextSolver(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(Problem problemDifficulty) {
        if (canSolve(problemDifficulty)) {
            solve(problemDifficulty);
        } else if (nextApprover != null) {
            nextApprover.processRequest(problemDifficulty); // Передача запроса дальше
        } else {
            System.out.println("Проблема не может быть решена");
        }
    }

    protected abstract boolean canSolve(Problem amount); // Проверка лимита
    protected abstract void solve(Problem amount); // Логика одобрения
}
