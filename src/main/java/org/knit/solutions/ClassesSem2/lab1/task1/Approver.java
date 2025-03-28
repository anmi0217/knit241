package org.knit.solutions.ClassesSem2.lab1.task1;

// Абстрактный класс обработчика
public abstract class Approver {
    protected Approver nextApprover; // Следующий обработчик в цепочке

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(Problem problem) {
        int amount = problem.getAmount();
        String description = problem.getDescription();
        if (canApprove(amount)) {
            approve(amount, description);
        } else if (nextApprover != null) {
            nextApprover.processRequest(problem); // Передача запроса дальше
        } else {
            System.out.println("Запрос " + problem.getDescription() + "; Cумма: $"
                    + amount + " отклонен: Превышает лимит.");
        }
    }

    protected abstract boolean canApprove(int amount); // Проверка лимита

    protected abstract void approve(int amount, String description); // Логика одобрения
}
