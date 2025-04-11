package org.knit.solutions.labor2.lab1.chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        // Создаем обработчиков
        Approver callCenter = new CallCenter();
        Approver manager = new Manager();
        Approver legalDepartment = new LegalDepartment();
        Problem problem = new Problem(10);

        // Устанавливаем цепочку: junior -> senior -> director
        callCenter.setNextSolver(manager);
        manager.setNextSolver(legalDepartment);

        // Запросы на одобрение разных сумм
        callCenter.processRequest(problem);   // Младший менеджер одобряет
//        callCenter.processRequest(40);  // Старший менеджер одобряет
//        callCenter.processRequest(60); // Директор одобряет
//        callCenter.processRequest(100); // Превышает лимит – запрос отклонен
    }
}
