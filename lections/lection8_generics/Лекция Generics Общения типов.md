
---

### 1. [Введение в Generics](%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%B2%20Generics.md)

1. **Проблема без Generics:**
    - Рассмотрение примеров с использованием `Object`.
    - Демонстрация ошибок времени выполнения из-за преобразований типов (casting).
2. **Generics как решение:**
    - Обеспечение безопасности типов (type safety).
    - Уменьшение необходимости приведения типов (casting).
    - Повышение читаемости и устойчивости к ошибкам.
3. **Синтаксис Generics:**
    - Общее объяснение `<T>` — обобщения.
    - Введение понятий параметров типов и их использование.

Код-пример:

```java
List<Object> list = new ArrayList<>();
list.add("String");
list.add(123); // Проблема: разнородные типы

List<String> genericList = new ArrayList<>();
genericList.add("String");
// genericList.add(123); // Ошибка компиляции
```

---

### 2. [Основы Generics](%D0%9E%D1%81%D0%BD%D0%BE%D0%B2%D1%8B%20Generics.md)


1. **Generics в коллекциях:**
    - Коллекции `List`, `Set`, `Map`.
    - Объяснение их реализации с Generics.
2. **Объявление обобщённых классов:**
    - Создание своего класса с параметром типа `<T>`.
    - Пример: класс-контейнер.

Код-пример:

```java
public class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// Использование
Box<String> stringBox = new Box<>();
stringBox.setValue("Hello");
System.out.println(stringBox.getValue());
```

3. **Обобщённые методы:**
    - Объявление и использование методов с параметрами типов.

Код-пример:

```java
public static <T> void printArray(T[] array) {
    for (T element : array) {
        System.out.println(element);
    }
}
```

---

### 3.  [Wildcards в Java](Wildcards%20%D0%B2%20Java.md)

1. **Типы Wildcards:**
    
    - `<?>` — неизвестный тип.
    - `<? extends Type>` — ограничение сверху (Upper Bound).
    - `<? super Type>` — ограничение снизу (Lower Bound).
2. **Примеры использования:**
    
    - Работа с коллекциями с неизвестным типом.
    - Ограничение типов в методах.

Код-пример:

```java
public void processNumbers(List<? extends Number> numbers) {
    for (Number number : numbers) {
        System.out.println(number);
    }
}
```

3. **Когда использовать Wildcards:**
    - Чтение данных из коллекции.
    - Запись данных в коллекцию.

---

### 4. [Ограничения Generics](%D0%9E%D0%B3%D1%80%D0%B0%D0%BD%D0%B8%D1%87%D0%B5%D0%BD%D0%B8%D1%8F%20Generics.md)

1. **Примеры ограничений:**
    
    - Невозможно создать экземпляры типов (`new T()`).
    - Ограничения на примитивы (`List<int>` не разрешено).
    - Ограничения на статические члены с типом `<T>`.
2. **Решение проблемы с примитивами:**
    
    - Использование обёрточных классов (`Integer`, `Double` и т.д.).
3. **Generic и наследование:**
    
    - Разница между `List<Object>` и `List<?>`.

---

### 5. [Реальные примеры](%D0%A0%D0%B5%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5%20%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80%D1%8B.md)

1. **Стандартные классы с Generics:**
    - `HashMap<K, V>`, `Optional<T>`, `Stream<T>`.
2. **Реализация универсального метода фильтрации:**
    - Пример с использованием Generics.



---

