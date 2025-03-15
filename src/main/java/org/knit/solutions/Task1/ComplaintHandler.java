package org.labs.Tasks2.Task1;

abstract class ComplaintHandler {
    protected ComplaintHandler nextHandler;

    public void setNextHandler(ComplaintHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleComplaint(Complaint complaint) {
        if (canHandle(complaint)) {
            resolve(complaint);
        } else if (nextHandler != null) {
            nextHandler.handleComplaint(complaint);
        } else {
            System.out.println("Жалоба \"" + complaint.getDescription() + "\" не может быть решена.");
        }
    }

    protected abstract boolean canHandle(Complaint complaint);
    protected abstract void resolve(Complaint complaint);
}
