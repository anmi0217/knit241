package org.knit.solutions.TaskSem1;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;
import org.knit.solutions.ClassesSem1.lab1.SimpleUrl;

/***
 * Задача 2
 * Создайте класс SimpleUrl
 * глядя на URL ниже создайте как можно больше полей в классе SimpleUrl:
 * https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText
 * добавьте геттеры и сеттеры для полей
 * Переопределите метод toString() для вывода информации о полях класса:
 * protocol = https
 * address = test.ru
 * domainZone = ru
 * siteName = test
 * webpageName = page.jsp
 * webPageExtention = jsp
 * ....
 * Распарсите данный URL на переменные, создайте экземпляр класса SimpleUrl и выведите на экран
 * Дополнительно
 * попробуйте с другими URL в сети, подумайте как можно сгруппировать значения.
 *
 */

@TaskDescription(taskNumber = 2,
        taskDescription = "Распарсить URL",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2 implements Solution {
    public void execute() {

        String urlValue = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";

        // Разбираем URL
        String[] parts = urlValue.split("://");
        String protocol = parts[0];
        String restOfUrl = parts[1];

        String[] addressAndParams = restOfUrl.split("\\?");
        String addressPart = addressAndParams[0];
        String paramsPart = addressAndParams.length > 1 ? addressAndParams[1] : "";

        // Разбираем адрес
        String[] addressParts = addressPart.split("/");
        String address = addressParts[0];
        String[] domainParts = address.split("\\.");
        String domainZone = domainParts[1];
        String siteName = domainParts[0];

        String webpage = addressParts[addressParts.length - 1];
        String[] webpageParts = webpage.split("\\.");
        String webpageName = webpageParts[0];
        String webpageExtension = webpageParts[1];

        // Разбираем параметры
        String[] params = paramsPart.split("&");
        String intParam = "";
        String doubleParam = "";
        String textParam = "";

        for (String param : params) {
            if (param.startsWith("intParam=")) {
                intParam = param.split("=")[1];
            } else if (param.startsWith("doubleParam=")) {
                doubleParam = param.split("=")[1];
            } else if (param.startsWith("textParameter=")) {
                textParam = param.split("=")[1];
            }
        }

        // Создаем объект SimpleUrl
        SimpleUrl url = new SimpleUrl();
        url.setProtocol(protocol);
        url.setAddress(address);
        url.setDomainZone(domainZone);
        url.setSiteName(siteName);
        url.setWebpageName(webpageName);
        url.setWebpageExtension(webpageExtension);
        url.setIntParam(intParam);
        url.setDoubleParam(doubleParam);
        url.setTextParam(textParam);

        // Выводим информацию об URL
        System.out.println(url);
    }
}

