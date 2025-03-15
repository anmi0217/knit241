package org.knit.solutions.Task1;

class SeniorManagerHandler extends ComplaintHandler {

    public SeniorManagerHandler() {
        setNextHandler(new LegalDepartmentHandler());
    }

    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getDifficulty() <= 9;
    }

    @Override
    protected void resolve(Complaint complaint) {
        System.out.println("Старший менеджер решил проблему: " + complaint.getDescription());
    }
}
