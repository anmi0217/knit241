package org.labs.Tasks2.Task1;

class CallCenterHandler extends ComplaintHandler {

    public CallCenterHandler() {
        setNextHandler(new ManagerHandler());
    }

    @Override
    protected boolean canHandle(Complaint complaint) {
        return complaint.getDifficulty() <= 3;
    }

    @Override
    protected void resolve(Complaint complaint) {
        System.out.println("Колл-центр решил проблему: " + complaint.getDescription());
    }
}
