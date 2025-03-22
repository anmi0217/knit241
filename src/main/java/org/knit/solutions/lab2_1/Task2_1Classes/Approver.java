package org.knit.solutions.lab2_1.Task2_1Classes;

// Абстрактный класс обработчика
abstract class Approver {
    protected Approver nextApprover; // Следующий обработчик в цепочке

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(ClientProblem complaint) {
        if (canApprove(complaint)) {
            approve(complaint);
        } else if (nextApprover != null) {
            nextApprover.processRequest(complaint); // Передача запроса дальше
        } else {
            System.out.println("Запрос на сумму $" + complaint + " отклонен: превышает лимит.");
        }
    }

    protected abstract boolean canApprove(ClientProblem complaint);
    protected abstract void approve(ClientProblem complaint); // Логика одобрения

}