package org.labs.Tasks2.Task1;

class LegalDepartmentHandler extends ComplaintHandler {


    @Override
    protected boolean canHandle(Complaint complaint) {
        return true;
    }

    @Override
    protected void resolve(Complaint complaint) {
        System.out.println("Юридический отдел решил проблему: " + complaint.getDescription());
    }
}