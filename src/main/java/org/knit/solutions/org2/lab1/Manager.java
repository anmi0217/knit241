package org.knit.solutions.org2.lab1;

public class Manager extends Approver {
    public Manager(String name) {
        super(name);
    }

    @Override
    protected boolean canApprove(int difficulty) {
        return difficulty <= 6;
    }

    @Override
    protected void approve(Problem problem) {
        System.out.println("Менеджер " + getName() + " обрабатывает запрос: " + problem.getDescription());
    }
}
