package org.knit.lab1;

/***
 Вывести на экран числа от 1 до 100 через запятую, переходя на новую строку каждые 10 чисел
 ***/
public class Task1 {

    public void execute() {

        String line = "1";
        for(int i = 1; i <= 100; i++){
            if (i % 10 == 0) {
                System.out.println(i);
            } else {
                System.out.print(i + ", ");
            }
        }
    }
}
