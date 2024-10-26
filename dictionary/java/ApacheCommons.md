### 1. **Проверка пустоты и пустого пространства**

- **`StringUtils.isEmpty(String str)`**  
  Проверяет, является ли строка пустой (`null` или `""`).

- **`StringUtils.isBlank(String str)`**  
  Проверяет, является ли строка пустой или содержит только пробельные символы (например, пробелы, табуляции, переводы строки).

**Примеры:**

```java
StringUtils.isEmpty("");        // true
StringUtils.isEmpty(" ");       // false
StringUtils.isBlank(" ");       // true
StringUtils.isBlank("\n\t");    // true
```

### 2. **Проверка начала и конца строки**

- **`StringUtils.startsWith(String str, String prefix)`**  
  Проверяет, начинается ли строка с указанного префикса.

- **`StringUtils.endsWith(String str, String suffix)`**  
  Проверяет, заканчивается ли строка указанным суффиксом.

**Примеры:**

```java
StringUtils.startsWith("hello world", "hello"); // true
StringUtils.endsWith("hello world", "world");   // true
```

### 3. **Преобразование регистра**

- **`StringUtils.capitalize(String str)`**  
  Преобразует первую букву строки в верхний регистр.

- **`StringUtils.uncapitalize(String str)`**  
  Преобразует первую букву строки в нижний регистр.

- **`StringUtils.upperCase(String str)`**  
  Преобразует всю строку в верхний регистр.

- **`StringUtils.lowerCase(String str)`**  
  Преобразует всю строку в нижний регистр.

**Примеры:**

```java
StringUtils.capitalize("hello");   // "Hello"
StringUtils.uncapitalize("Hello"); // "hello"
StringUtils.upperCase("hello");    // "HELLO"
StringUtils.lowerCase("HELLO");    // "hello"
```

### 4. **Удаление пробелов**

- **`StringUtils.trim(String str)`**  
  Удаляет начальные и конечные пробелы из строки.

- **`StringUtils.strip(String str)`**  
  Похоже на `trim`, но также удаляет пробельные символы, такие как табуляции и переводы строки.

- **`StringUtils.stripToEmpty(String str)`**  
  Удаляет пробелы и возвращает пустую строку, если строка `null`.

**Примеры:**

```java
StringUtils.trim("   hello   ");         // "hello"
StringUtils.strip(" \n\t hello \t\n ");  // "hello"
StringUtils.stripToEmpty(null);          // ""
```

### 5. **Замена подстрок**

- **`StringUtils.replace(String text, String searchString, String replacement)`**  
  Заменяет все вхождения `searchString` в строке на `replacement`.

- **`StringUtils.replaceEach(String text, String[] searchList, String[] replacementList)`**  
  Заменяет несколько подстрок одновременно.

**Примеры:**

```java
StringUtils.replace("Hello World", "World", "Java"); // "Hello Java"
StringUtils.replaceEach("abc123", new String[]{"a", "1"}, new String[]{"x", "9"}); // "xbc923"
```

### 6. **Проверка содержимого строки**

- **`StringUtils.contains(String str, String searchStr)`**  
  Проверяет, содержит ли строка подстроку.

- **`StringUtils.containsIgnoreCase(String str, String searchStr)`**  
  Проверяет, содержит ли строка подстроку, игнорируя регистр.

**Примеры:**

```java
StringUtils.contains("hello world", "world");          // true
StringUtils.containsIgnoreCase("hello world", "WORLD"); // true
```

### 7. **Объединение строк**

- **`StringUtils.join(Object[] array, String separator)`**  
  Объединяет элементы массива в строку с указанным разделителем.

- **`StringUtils.join(Iterable<?> iterable, String separator)`**  
  Объединяет элементы коллекции в строку с указанным разделителем.

**Примеры:**

```java
String[] words = {"apple", "banana", "cherry"};
StringUtils.join(words, ", "); // "apple, banana, cherry"
```

### 8. **Обратный порядок символов**

- **`StringUtils.reverse(String str)`**  
  Возвращает строку в обратном порядке.

**Пример:**

```java
StringUtils.reverse("abc"); // "cba"
```

### 9. **Удаление символов**

- **`StringUtils.remove(String str, char remove)`**  
  Удаляет все вхождения указанного символа из строки.

- **`StringUtils.removeStart(String str, String remove)`**  
  Удаляет указанную подстроку в начале строки, если она присутствует.

- **`StringUtils.removeEnd(String str, String remove)`**  
  Удаляет указанную подстроку в конце строки, если она присутствует.

**Примеры:**

```java
StringUtils.remove("hello", 'l');         // "heo"
StringUtils.removeStart("www.example.com", "www."); // "example.com"
StringUtils.removeEnd("example.txt", ".txt");       // "example"
```

### 10. **Повторение строки**

- **`StringUtils.repeat(String str, int repeat)`**  
  Повторяет строку заданное количество раз.

**Пример:**

```java
StringUtils.repeat("abc", 3); // "abcabcabc"
```

### Подключение Apache Commons Lang через Maven

Чтобы использовать `StringUtils` и другие утилиты из Apache Commons Lang, добавьте следующую зависимость в ваш `pom.xml`:

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.12.0</version>
</dependency>
```
