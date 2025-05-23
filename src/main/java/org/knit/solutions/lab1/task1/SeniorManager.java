package org.knit.solutions.lab1.task1;

public class SeniorManager extends Approver {
    @Override
    protected boolean isEligible(int amount) {
        return amount <= 10000;
    }

    @Override
    protected void approveRequest(int amount, String description) {
        System.out.println("Старший менеджер одобрил заявку: \"" + description + "\" на сумму $" + amount);
    }
}
