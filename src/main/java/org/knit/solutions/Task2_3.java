package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2_1.Task2_3Classes.Transport;
import org.knit.solutions.lab2_1.Task2_3Classes.TransportFactory;

import java.util.Scanner;

@TaskDescription(taskNumber = 3, taskDescription = "Factory. " +
        "Реализуйте фабрику по созданию различных видов транспортных средств в системе каршеринга.\n", href = "org/knit/solutions/lab2_1/Task2_3Classes")
public class Task2_3 implements Solution{
    public void execute() throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите тип поездки(business, long_family_journey, fast_delivery):");
        String travelType = scanner.next();
        Transport transport = TransportFactory.createTransport(travelType);
        System.out.println("Мы подобрали для вас средство передвижения! Взгляните:\n" + transport.getSpecifications());

    }
}
