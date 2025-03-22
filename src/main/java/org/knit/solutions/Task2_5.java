package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_2.Task2_5Classes.Cook;
import org.knit.solutions.lab2_2.Task2_5Classes.Restaurant;
import org.knit.solutions.lab2_2.Task2_5Classes.Waiter;

@TaskDescription(taskNumber = 5, taskDescription = "многопоточность. " +
        "В ресторане работает один повар и один официант. " +
        " Повар готовит блюда и ставит их на поднос (максимум 3 блюда). " +
        " Официант берет готовые блюда и подает их клиентам.\n", href = "org/knit/solutions/lab2_2/Task2_5Classes")
public class Task2_5 implements Solution{
    public void execute() {
        Restaurant rest = new Restaurant();

        Cook cook = new Cook(rest);
        Waiter waiter = new Waiter(rest);

        cook.start();
        waiter.start();
    }
}
