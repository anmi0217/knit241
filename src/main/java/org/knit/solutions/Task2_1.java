package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.lab2_1.Task2_1Classes.*;

@TaskDescription(taskNumber = 1, taskDescription = "Chain of Responsibility. " +
        "Реализуйте систему обработки жалоб клиентов в банке с помощью цепочки обязанностей.", href = "org/knit/solutions/lab2_1/Task2_1Classes")
public class Task2_1 implements Solution{
    public void execute() {
        ClientProblem problem = new ClientProblem(ProblemDifficulty.NORMAL, "Документы",
                "как сделать справку номер 4627831546702364789");
        ClientProblem problem2 = new ClientProblem(ProblemDifficulty.MOST_DIFFICULT,
                "Судимость", "как шггрывепщлрепгриищрииорешгнр");

        Lawyer lawyer = new Lawyer();
        DepartmentConsultant consultant = new DepartmentConsultant(lawyer);
        Manager manager = new Manager(consultant);
        CallCenter callCenter = new CallCenter(manager);

        callCenter.approve(problem);
        callCenter.approve(problem2);
    }
}
