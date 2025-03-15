package org.labs.Tasks2.Task1;

class ManagerHandler extends ComplaintHandler {

    public ManagerHandler() {
        setNextHandler(new SeniorManagerHandler());
    }

    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getDifficulty() <= 6;
    }

    @Override
    protected void resolve(Complaint complaint) {
        System.out.println("Менеджер решил проблему: " + complaint.getDescription());
    }
}