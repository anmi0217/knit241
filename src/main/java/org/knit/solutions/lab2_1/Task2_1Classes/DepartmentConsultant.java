package org.knit.solutions.lab2_1.Task2_1Classes;

public class DepartmentConsultant extends Approver {

    @Override
    protected boolean canApprove(ClientProblem complaint) {
        if (ProblemDifficulty.HIGH.equals(complaint.getDifficulty())) {
            return true;
        }
        return false;
    }

    @Override
    protected void approve(ClientProblem complaint) {
        if (canApprove(complaint)) {
            System.out.println("Получен ответ от консультанта юридического департамента по теме " + complaint.getTheme());
        } else {
            nextApprover.approve(complaint);
        }
    }

    public DepartmentConsultant(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}
