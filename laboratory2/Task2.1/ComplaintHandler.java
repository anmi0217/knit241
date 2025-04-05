package Semestr_2.Task1;

abstract class ComplaintHandler {
    protected ComplaintHandler nextHandler;

    public void setNextHandler(ComplaintHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleComplaint(Complaint complaint) {
        if (canHandle(complaint)) {
            processComplaint(complaint);
        } else if (nextHandler != null) {
            nextHandler.handleComplaint(complaint);
        } else {
            System.out.println("Жалоба не может быть обработана: " + complaint.getDescription());
        }
    }

    protected abstract boolean canHandle(Complaint complaint);
    protected abstract void processComplaint(Complaint complaint);
}