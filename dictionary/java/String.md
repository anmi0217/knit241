В Java класс `String` представляет собой неизменяемую последовательность символов. Это один из самых часто используемых классов, и он предоставляет множество методов для работы со строками.

### Пример работы со строками

```java
public class StringExample {
    public static void main(String[] args) {
        // Создание строки
        String str1 = "Hello, World!";
        String str2 = new String("Java programming");

        // Получение длины строки
        int length = str1.length();
        System.out.println("Длина строки str1: " + length); // 13

        // Получение символа по индексу
        char character = str1.charAt(0);
        System.out.println("Первый символ строки str1: " + character); // 'H'

        // Сравнение строк
        boolean equals = str1.equals("Hello, World!");
        System.out.println("str1 равна 'Hello, World!': " + equals); // true

        // Сравнение строк без учета регистра
        boolean equalsIgnoreCase = str1.equalsIgnoreCase("hello, world!");
        System.out.println("str1 равна 'hello, world!' без учета регистра: " + equalsIgnoreCase); // true

        // Конкатенация строк (объединение)
        String str3 = str1.concat(" ").concat(str2);
        System.out.println("Объединение str1 и str2: " + str3); // "Hello, World! Java programming"

        // Проверка наличия подстроки
        boolean contains = str1.contains("World");
        System.out.println("str1 содержит 'World': " + contains); // true

        // Получение подстроки
        String substring = str1.substring(7, 12);
        System.out.println("Подстрока str1: " + substring); // "World"

        // Замена символов в строке
        String replaced = str1.replace("World", "Java");
        System.out.println("Замена 'World' на 'Java': " + replaced); // "Hello, Java!"

        // Приведение к нижнему регистру
        String lowerCase = str1.toLowerCase();
        System.out.println("str1 в нижнем регистре: " + lowerCase); // "hello, world!"

        // Приведение к верхнему регистру
        String upperCase = str1.toUpperCase();
        System.out.println("str1 в верхнем регистре: " + upperCase); // "HELLO, WORLD!"

        // Удаление пробелов в начале и конце строки
        String str4 = "  Java  ";
        String trimmed = str4.trim();
        System.out.println("Строка без лишних пробелов: '" + trimmed + "'"); // "Java"

        // Разбиение строки на части
        String str5 = "apple,banana,orange";
        String[] fruits = str5.split(",");
        System.out.println("Разбиение строки: ");
        for (String fruit : fruits) {
            System.out.println(fruit); // apple, banana, orange
        }

        // Проверка на пустоту
        boolean isEmpty = "".isEmpty();
        System.out.println("Проверка на пустоту: " + isEmpty); // true

        // Превращение числа в строку
        int number = 100;
        String numberString = String.valueOf(number);
        System.out.println("Число в строковом формате: " + numberString); // "100"
    }
}
```

### Операции со строками

1. **Создание строки**:
    - `String str1 = "Hello";` — строка может быть создана как литерал.
    - `String str2 = new String("Hello");` — можно создать строку через конструктор, но это используется редко.

2. **Получение длины строки**:
    - `str.length()` — возвращает длину строки.

3. **Получение символа по индексу**:
    - `str.charAt(index)` — возвращает символ на указанной позиции (индекс начинается с 0).

4. **Сравнение строк**:
    - `str.equals(anotherString)` — сравнивает строки с учетом регистра.
    - `str.equalsIgnoreCase(anotherString)` — сравнивает строки без учета регистра.

5. **Конкатенация строк**:
    - `str.concat(anotherString)` — объединяет строки.
    - Также можно использовать оператор `+` для объединения строк: `"Hello" + " " + "World!"`.

6. **Поиск подстроки**:
    - `str.contains(substring)` — проверяет, содержит ли строка указанную подстроку.
    - `str.indexOf(substring)` — возвращает индекс первого вхождения подстроки или `-1`, если подстрока не найдена.
    - `str.lastIndexOf(substring)` — возвращает индекс последнего вхождения подстроки.

7. **Извлечение подстроки**:
    - `str.substring(start, end)` — возвращает подстроку с индекса `start` по индекс `end` (не включая `end`).

8. **Замена подстроки**:
    - `str.replace(oldChar, newChar)` — заменяет все вхождения символа или подстроки.

9. **Изменение регистра**:
    - `str.toLowerCase()` — переводит строку в нижний регистр.
    - `str.toUpperCase()` — переводит строку в верхний регистр.

10. **Удаление пробелов**:
    - `str.trim()` — удаляет пробелы в начале и в конце строки.

11. **Разбиение строки**:
    - `str.split(regex)` — разбивает строку на массив строк по регулярному выражению.

12. **Проверка на пустоту**:
    - `str.isEmpty()` — возвращает `true`, если строка пустая (не содержит символов).

13. **Преобразование данных в строку**:
    - `String.valueOf(someValue)` — преобразует переданное значение в строку (например, число или объект).

### Важные моменты

- **Неизменяемость строк**: Строки в Java неизменяемы. Операции, такие как `concat()`, `replace()`, или `substring()`, не изменяют исходную строку, а возвращают новую строку.
- **String Pool**: Строки, созданные как литералы, сохраняются в специальной области памяти, называемой "string pool". Это позволяет избежать создания дубликатов одинаковых строк, повышая производительность.

