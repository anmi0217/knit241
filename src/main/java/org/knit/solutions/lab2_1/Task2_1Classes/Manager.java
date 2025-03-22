package org.knit.solutions.lab2_1.Task2_1Classes;


public class Manager extends Approver {

    @Override
    protected boolean canApprove(ClientProblem complaint) {
        if (ProblemDifficulty.NORMAL.equals(complaint.getDifficulty())) {
            return true;
        }
        return false;
    }

    @Override
    protected void approve(ClientProblem complaint) {
        if (canApprove(complaint)) {
            System.out.println("Получен ответ от менеджера по теме " + complaint.getTheme());
        } else {
            nextApprover.approve(complaint);
        }
    }

    public Manager(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}
