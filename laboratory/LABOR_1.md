# Лабораторная работа № 1

## Цель работы:
 - Научиться создавать package
 - Научиться работе с экземплярами классов Java
 - Научиться работать со структурой проекта
 - Научиться выполнять простые оперции
 - Познакомиться с типами данных

#### Задача 1

Вывести на экран числа от 1 до 100 через запятую, переходя на новую строку каждые 10 чисел

инструменты:
```java
String line = "";
line = line + 1 + "," + "\n" + "2";
System.out.println(line);
//1,
//2
```


#### Задача 2 *

Создайте класс SimpleUrl
глядя на URL ниже создайте как можно больше полей в классе SimpleUrl:

    https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText

Добавьте геттеры и сеттеры для полей класса SimpleUrl
    
Переопределите метод toString() для вывода информации о полях класса:

    protocol = https
    address = test.ru
    domainZone = ru
    siteName = test
    webpageName = page.jsp
    webPageExtention = jsp

Распарсите данный URL на переменные, создайте экземпляр класса **SimpleUrl** и выведите на экран

##### Дополнительно

Попробуйте с другими URL в сети, подумайте как можно сгруппировать значения.

Пример оформления можно посмотреть здесь
https://github.com/anmi0217/knit241_template/blob/master/src/main/java/org/knit/lab1/Task2.java

Запушить изменения. Отправить ссылку используя google form
https://forms.gle/LudRvtVqjYpSM1ZL7






    
