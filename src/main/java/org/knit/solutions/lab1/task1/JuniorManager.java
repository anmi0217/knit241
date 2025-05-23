package org.knit.solutions.lab1.task1;

public class JuniorManager extends Approver {
    @Override
    protected boolean isEligible(int amount) {
        return amount <= 1000;
    }

    @Override
    protected void approveRequest(int amount, String description) {
        System.out.println("Младший менеджер одобрил заявку: \"" + description + "\" на сумму $" + amount);
    }
}
