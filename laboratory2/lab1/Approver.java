package org2.lab1;

abstract class Approver {
    protected Approver nextApprover;
    private String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(Problem problem) {
        int difficulty = problem.getDifficult();
        if (canApprove(difficulty)) {
            approve(problem);
        } else if (nextApprover != null) {
            nextApprover.processRequest(problem); // Передача запроса дальше
        } else {
            System.out.println("Запрос с уровнем сложности " + difficulty + " не может быть обработан.");
        }
    }

    protected abstract boolean canApprove(int difficulty); // Проверка лимита
    protected abstract void approve(Problem problem); // Логика одобрения

    public String getName() {
        return name;
    }
}
