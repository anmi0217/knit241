package Semestr_2.Task1;

class LegalDepartmentHandler extends ComplaintHandler {
    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getComplexityLevel() <= 3;
    }

    @Override
    protected void processComplaint(Complaint complaint) {
        System.out.println("Юридический отдел обрабатывает жалобу: " + complaint.getDescription());
    }
}