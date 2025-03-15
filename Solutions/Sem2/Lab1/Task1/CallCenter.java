package org2.lab1;

public class CallCenter extends Approver {
    public CallCenter(String name) {
        super(name);
    }

    @Override
    protected boolean canApprove(int difficulty) {
        return difficulty <= 3;
    }

    @Override
    protected void approve(Problem problem) {
        System.out.println("Колл-центр " + getName() + " обрабатывает запрос: " + problem.getDescription());
    }
}
