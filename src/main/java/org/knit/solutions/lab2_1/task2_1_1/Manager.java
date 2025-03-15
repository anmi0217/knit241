package org.knit.solutions.lab2_1.task2_1_1;

public abstract class Manager {
    protected Manager nextManager;

    public void setNextManager(Manager nextManager) {
        this.nextManager = nextManager;
    }

    public void processRequest(Problem problem) {
        if (canApprove(problem)) {
            approve(problem);
        } else if (nextManager != null) {
            nextManager.processRequest(problem); // Передача запроса дальше
        } else {
            System.out.println("Запрос на сложность: " + problem.getDifficult() + "\nотклонен: превышает лимит.");
        }
    }

    protected abstract boolean canApprove(Problem problem); // Проверка лимита
    protected abstract void approve(Problem problem); // Логика одобрения
}
