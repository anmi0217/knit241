package org.knit.solutions.TaskSem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab4.task1.Solution;

/***
 * Задача №9 *
 *
 * Создайте консольное приложение, которое в течение минуты предлагает пользователю вводить случайные слова из списка.
 *
 * Функции:
 * - Приложение берет случайное слово из списка и ждет ввода пользователя.
 * - Если слово введено правильно, увеличиваем счетчик правильных слов.
 * - Засекаем время (1 минута). Последнее введенное слово после истечения времени не учитывается.
 * - В конце выводим статистику:
 *   - Общее количество предложенных слов
 *   - Количество правильных слов
 *   - Количество введенных символов
 *   - Скорость ввода символов в секунду
 *
 * Требования:
 * - Использовать System.currentTimeMillis() для контроля времени.
 * - Слова берутся из файла dictionary.txt
 * - Использовать Scanner для ввода пользователя
 */


@TaskDescription(taskNumber = 9,
        taskDescription = "Скорость рукописного ввода",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task9 implements Solution {
    public void execute() {
        List<String> words = getWords();

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int lenghtWorlds = words.size();

        //получает текущее время в миллисекундах
        long timeMillis = System.currentTimeMillis();
        long timeAfterMinute = timeMillis + 60000;

        int countWorld = 0;
        int countRightWorld = 0;
        int countSymbol = 0;

        while (System.currentTimeMillis() < timeAfterMinute) {
            int indexRandomWord = random.nextInt(lenghtWorlds);
            String randomWord = words.get(indexRandomWord);
            countWorld++;
            System.out.println("Введите слово: " + randomWord);
            String inputWord = scanner.next();

            System.out.println("Прошло " + ((System.currentTimeMillis() - timeMillis) / 1000) + " секунд.");
            countSymbol += inputWord.length();
            if ((randomWord.equalsIgnoreCase(inputWord)) && (System.currentTimeMillis() <= timeAfterMinute)) {
                countRightWorld++;
            }
        }

        System.out.println("Всего было слов: " + countWorld);
        System.out.println("Было введено верных слов во время: " + countRightWorld);
        System.out.println("Количество введенных символов: " + countSymbol);
        System.out.printf("Символов в секунду: %.5f", (double) countSymbol / 60);
    }


    //Возвращает список слов из файла
    public static List<String> getWords() {
        File file = new File("src/misc/dictionary.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            words.add(word);
        }
        scanner.close();
        return words;
    }
}