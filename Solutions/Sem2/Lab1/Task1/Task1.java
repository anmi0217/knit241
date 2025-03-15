package org2.lab1;

public class Task1 {
    public static void main(String[] args) {
        // Создаем уровни обработки
        CallCenter callCenter = new CallCenter("'Что сделаем, то сделаем'");
        Manager manager = new Manager("Кирилл");
        Specialist specialist = new Specialist("Дмитрий");
        LegalDepartment legalDepartment = new LegalDepartment("Елена");

        // Устанавливаем цепочку
        callCenter.setNextApprover(manager);
        manager.setNextApprover(specialist);
        specialist.setNextApprover(legalDepartment);

        // Создаем жалобы разного уровня сложности
        Problem complaint1 = new Problem(2, "Проблема с транзакцией.");
        Problem complaint2 = new Problem(5, "Вопрос по кредитной карте.");
        Problem complaint3 = new Problem(8, "Сложная юридическая проблема.");
        Problem complaint4 = new Problem(9, "Очень сложная юридическая проблема.");

        // Обрабатываем жалобы
        System.out.println("Обработка жалобы 1:");
        callCenter.processRequest(complaint1);

        System.out.println("\nОбработка жалобы 2:");
        callCenter.processRequest(complaint2);

        System.out.println("\nОбработка жалобы 3:");
        callCenter.processRequest(complaint3);

        System.out.println("\nОбработка жалобы 4:");
        callCenter.processRequest(complaint4);
        System.out.println("\nНичего не можем сделать, до свидания!");
    }
}
