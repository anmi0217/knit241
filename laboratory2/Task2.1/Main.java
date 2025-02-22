package Semestr_2.Task1;

public class Main {
    public static void main(String[] args) {
        ComplaintHandler callCenter = new CallCenterHandler();
        ComplaintHandler manager = new ManagerHandler();
        ComplaintHandler legalDepartment = new LegalDepartmentHandler();
        ComplaintHandler executive = new ExecutiveHandler();

        callCenter.setNextHandler(manager);
        manager.setNextHandler(legalDepartment);
        legalDepartment.setNextHandler(executive);

        Complaint simpleComplaint = new Complaint("Не работает карта", 1);
        Complaint mediumComplaint = new Complaint("Ошибка в переводе", 2);
        Complaint complexComplaint = new Complaint("Юридический спор", 3);
        Complaint criticalComplaintSystem = new Complaint("Критическая ошибка в системе", 4);
        Complaint criticalComplaint = new Complaint("Критическая ошибка", 5);

        callCenter.handleComplaint(simpleComplaint);
        callCenter.handleComplaint(mediumComplaint);
        callCenter.handleComplaint(complexComplaint);
        callCenter.handleComplaint(criticalComplaintSystem);
        callCenter.handleComplaint(criticalComplaint);
    }
}
