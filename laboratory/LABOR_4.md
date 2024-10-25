# Лабораторная работа № 4

## Цель

- Научиться работать с массивами
- Научиться работать со строками

## Задача № 7 *

Добавьте в проект файл словарь [dictionary.txt](..%2Fmisc%2Fdictionary.txt)

Используя класс Scanner можно добавить путь к файлу dictionary

```java
import java.io.File;
import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(new File("misc/dictionary.txt"));
    while (scanner.hasNext()) {
        String word = scanner.nextLine();
    }
    scanner.close();
}
```

Создайте class DictionaryStatistic который имеет следующий вид 

```java
class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов 
    private int polindrom; // Количество слов полиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
    }

    // получить случайное слово из словаря
    public String getRandomWord() {
        /*
                реализация
        */
    }

    public void printSymbolsStat() {
        /*
                Выведите количество встречающихся букв:
                Пример
                а - 100
                б - 10
                в - 12
                ... 
                я - 1 
         */
    }

}
```

- реализуйте его методы
- добавляйте свои методы при необходимости

## Дополнительно *

Имитируйте игру в слова:

В консоль на вход подается слово, нужно составить как можно больше слов из его букв.

пример:
На входе

```
Введите слово:
Библиотека
```

на выходе варианты слов:

```
акт
лот
толк
табло
...
```











