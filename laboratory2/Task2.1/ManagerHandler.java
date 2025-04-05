package Semestr_2.Task1;

class ManagerHandler extends ComplaintHandler {
    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getComplexityLevel() <= 2;
    }

    @Override
    protected void processComplaint(Complaint complaint) {
        System.out.println("Менеджер обрабатывает жалобу: " + complaint.getDescription());
    }
}