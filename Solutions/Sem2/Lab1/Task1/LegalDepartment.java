package org2.lab1;

public class LegalDepartment extends Approver {
    public LegalDepartment(String name) {
        super(name);
    }

    @Override
    protected boolean canApprove(int difficulty) {
        return true; // Legal department can handle any difficulty
    }

    @Override
    protected void approve(Problem problem) {
        System.out.println("Юридический отдел " + getName() + " обрабатывает запрос: " + problem.getDescription());
    }
}
