package org.knit.solutions.Task1;

public abstract class Approver {
    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(Problem amount) {
        if (canApprove(amount)) {
            approve(amount);
        } else if (nextApprover != null) {
            nextApprover.processRequest(amount); // Передача запроса дальше
        } else {
            System.out.println("'" + amount.getText() + "', не рассматривается онлайн, необходимо подойти в банк.");
        }
    }

    protected abstract boolean canApprove(Problem amount);

    protected abstract void approve(Problem amount);
}
