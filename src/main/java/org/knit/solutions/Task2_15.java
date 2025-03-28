package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.lab2_5.Task2_15Classes.ImageProxy;

@TaskDescription(taskNumber = 15, taskDescription = "Прокси. Создайте удаленную библиотеку изображений. " +
        "При запросе изображения оно загружается с сервера (имитация через задержку в коде). " +
        "Картинка хранится как объект класса RealImage. " +
        "Прокси-объект ImageProxy должен лениво загружать изображение и кэшировать его для повторного использования.",
        href = "org/knit/solutions/lab2_5/Task2_15Classes")
public class Task2_15 implements Solution{
    @Override
    public void execute() throws ClassNotFoundException, InterruptedException {
        ImageProxy image = new ImageProxy();
        image.request();
        System.out.println();
        image.request();
    }
}
