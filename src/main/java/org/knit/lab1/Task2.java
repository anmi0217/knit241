package org.knit.lab1;

/***
 Создайте класс SimpleUrl глядя на URL ниже создайте как можно больше полей в классе SimpleUrl:

 https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText
 Добавьте геттеры и сеттеры для полей класса SimpleUrl

 Переопределите метод toString() для вывода информации о полях класса:

 protocol = https
 address = test.ru
 domainZone = ru
 siteName = test
 webpageName = page.jsp
 webPageExtention = jsp
 Распарсите данный URL на переменные, создайте экземпляр класса SimpleUrl и выведите на экран
 ***/
public class Task2 {
    public void execute() {

        String urlValue = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParametereter=someText";
        SimpleUrl url = new SimpleUrl();

        // Протокол
        String[] parts = urlValue.split("://");
        String protocol = parts[0];
        url.setProtocol(protocol);

        // Адрес сайта
        String[] addressAndPath = parts[1].split("/", 2);
        String address = addressAndPath[0];
        url.setAddress(address);

        // Доменная зона и имя сайта
        String[] domainParts = address.split("\\.");
        String domainZone = domainParts[domainParts.length - 1];
        String siteName = domainParts[domainParts.length - 2];
        url.setDomainZone(domainZone);
        url.setSiteName(siteName);

        // Веб-страница - имя и расширение
        String[] pathAndParams = addressAndPath[1].split("\\?");
        String[] pathParts = pathAndParams[0].split("/");
        String webpage = pathParts[pathParts.length - 1];
        String[] webpageParts = webpage.split("\\.");
        url.setWebpageName(webpageParts[0]);
        url.setWebPageExtention(webpageParts[1]);

        // Параметры запроса
        String[] queryParams = pathAndParams[1].split("&");
        for (String param : queryParams) {
            String[] paramParts = param.split("=");
            switch (paramParts[0]) {
                case "intParam":
                    url.setIntParam(paramParts[1]);
                    break;
                case "doubleParam":
                    url.setDoubleParam(paramParts[1]);
                    break;
                case "textParametereter":
                    url.settextParameter(paramParts[1]);
                    break;
            }
        }


        System.out.println(url);
        
    }
}

