Для практической части создадим простой проект для подсчета слов и строк в текстовом файле. Этот проект поможет закрепить основные навыки работы с `File`, `Files`, `BufferedReader` и другими классами для работы с файлами и потоками ввода-вывода в Java.

### Задание

Написать программу, которая:

1. Считывает текст из указанного текстового файла.
2. Подсчитывает количество строк в файле.
3. Подсчитывает количество слов в файле.
4. Выводит результаты на экран.

### Структура проекта

1. Создадим метод для чтения файла и подсчета строк.
2. Создадим метод для подсчета слов в каждой строке.
3. Используем `BufferedReader` для эффективного чтения данных.

### Пример реализации

Создадим файл `TextFileProcessor.java` с основным методом для подсчета строк и слов.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileProcessor {

    public static void main(String[] args) {
        // Укажите путь к файлу
        Path filePath = Paths.get("sample.txt");

        try {
            long lineCount = countLines(filePath);
            long wordCount = countWords(filePath);

            System.out.println("Количество строк: " + lineCount);
            System.out.println("Количество слов: " + wordCount);
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }

    // Метод для подсчета строк в файле
    private static long countLines(Path filePath) throws IOException {
        long lineCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        }

        return lineCount;
    }

    // Метод для подсчета слов в файле
    private static long countWords(Path filePath) throws IOException {
        long wordCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на слова, используя пробелы и другие разделители
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }

        return wordCount;
    }
}
```

### Объяснение кода

1. **`main`** — основной метод программы, в котором указывается путь к файлу. Мы вызываем методы `countLines` и `countWords`, чтобы получить количество строк и слов в файле.

2. **`countLines`** — метод, который подсчитывает количество строк в файле. С помощью `BufferedReader` и метода `readLine` читаем файл построчно. Для каждой строки увеличиваем счетчик строк на 1.

3. **`countWords`** — метод, который подсчитывает количество слов в файле. Мы читаем файл построчно, затем разбиваем каждую строку на массив слов с помощью `split("\\s+")`, где `\\s+` — регулярное выражение, соответствующее одному или нескольким пробелам. Длина массива слов добавляется к общему количеству слов.

### Тестирование

Для тестирования создайте текстовый файл `sample.txt` в той же директории, что и ваш проект, и добавьте в него текст. Запустите программу, и она выведет количество строк и слов в файле.

**Пример файла `sample.txt`:**
```
Hello, this is a simple file.
It contains a few lines of text.
Each line will be counted.
The words will also be counted.
```

**Пример вывода:**
```
Количество строк: 4
Количество слов: 17
```
