package Semestr_2.Task1;

class CallCenterHandler extends ComplaintHandler {
    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getComplexityLevel() <= 1;
    }

    @Override
    protected void processComplaint(Complaint complaint) {
        System.out.println("Колл-центр обрабатывает жалобу: " + complaint.getDescription());
    }
}