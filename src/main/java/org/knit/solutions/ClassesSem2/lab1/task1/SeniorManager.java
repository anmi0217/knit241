package org.knit.solutions.ClassesSem2.lab1.task1;

public class SeniorManager extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount <= 10000;
    }

    @Override
    protected void approve(int amount, String description) {
        System.out.println("Старший менеджер одобрил \"" + description + "\" на $" + amount);
    }
}
