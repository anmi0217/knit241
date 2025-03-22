package org.knit.solutions.lab2_1.Task2_1Classes;

public class CallCenter extends Approver {

    @Override
    protected boolean canApprove(ClientProblem p) {
        if (ProblemDifficulty.SIMPLE == p.getDifficulty()){
            return true;
        }
        return false;
    }

    @Override
    public void approve(ClientProblem p) {
        if (canApprove(p)) {
            System.out.println("Получен ответ от колл-центра по теме " + p.getTheme());
        } else {
            nextApprover.approve(p);
        }
    }

    public CallCenter(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}
