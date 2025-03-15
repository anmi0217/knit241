package org.knit.Solutions.Task1;

class ExecutiveHandler extends ComplaintHandler {
    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getComplexityLevel() <= 4;
    }

    @Override
    protected void processComplaint(Complaint complaint) {
        System.out.println("Руководство обрабатывает жалобу: " + complaint.getDescription());
    }
}