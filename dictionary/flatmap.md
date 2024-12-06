### Stream `flatMap` в Java

`flatMap` — это один из методов Streams API, который используется для преобразования каждого элемента потока в другой поток и затем "сворачивания" (flattening) всех этих потоков в один поток. Это особенно полезно при работе с вложенными структурами данных, такими как списки списков.

---

#### **Основная идея `flatMap`**
- Каждый элемент исходного потока преобразуется в поток (например, `Stream<List<T>>` → `Stream<T>`).
- Полученные потоки объединяются в один сплошной поток.

---

#### **Сигнатура метода:**
```java
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
```
- **`T`** — тип элементов исходного потока.
- **`R`** — тип элементов результирующего потока.
- **`mapper`** — функция, которая преобразует элемент типа `T` в поток типа `Stream<R>`.

---

### **Примеры использования `flatMap`**

#### **1. Обработка списка списков**
```java
import java.util.*;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("A", "B", "C"),
            Arrays.asList("D", "E"),
            Arrays.asList("F", "G", "H")
        );

        // Преобразуем список списков в единый поток
        List<String> flatList = nestedList.stream()
            .flatMap(List::stream) // Разворачиваем вложенные списки
            .collect(Collectors.toList());

        System.out.println(flatList);
    }
}
```

**Результат:**
```
[A, B, C, D, E, F, G, H]
```

**Пояснение:**
1. `nestedList.stream()` создает поток из списка списков.
2. `flatMap(List::stream)` преобразует каждый внутренний список в поток, а затем объединяет их в единый поток.
3. `collect(Collectors.toList())` собирает элементы в список.

---

#### **2. Работа с вложенными объектами**
Предположим, у нас есть класс `Person`, содержащий список книг:

```java
import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private List<String> books;

    public Person(String name, List<String> books) {
        this.name = name;
        this.books = books;
    }

    public List<String> getBooks() {
        return books;
    }
}

public class FlatMapExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", Arrays.asList("Book1", "Book2")),
            new Person("Bob", Arrays.asList("Book3", "Book4", "Book5")),
            new Person("Charlie", Arrays.asList("Book6"))
        );

        // Получаем список всех книг
        List<String> allBooks = people.stream()
            .flatMap(person -> person.getBooks().stream()) // Разворачиваем список книг каждого человека
            .collect(Collectors.toList());

        System.out.println(allBooks);
    }
}
```

**Результат:**
```
[Book1, Book2, Book3, Book4, Book5, Book6]
```

**Пояснение:**
1. `people.stream()` создает поток из объектов `Person`.
2. `flatMap(person -> person.getBooks().stream())` извлекает книги каждого человека в поток и объединяет их в единый поток.
3. `collect(Collectors.toList())` собирает книги в список.

---

#### **3. Удаление дубликатов из вложенных структур**
```java
import java.util.*;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<Integer>> nestedNumbers = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(3, 4, 5),
            Arrays.asList(5, 6, 7)
        );

        // Уникальные числа из всех списков
        List<Integer> uniqueNumbers = nestedNumbers.stream()
            .flatMap(List::stream) // Объединяем вложенные списки в поток
            .distinct()            // Убираем дубликаты
            .collect(Collectors.toList());

        System.out.println(uniqueNumbers);
    }
}
```

**Результат:**
```
[1, 2, 3, 4, 5, 6, 7]
```

---

### **Когда использовать `flatMap`?**
- Когда у вас есть вложенные структуры данных (например, списки списков).
- Для обработки данных, которые хранятся в сложных объектах.
- Для объединения нескольких потоков в один.

---

### **Чем `flatMap` отличается от `map`?**
- **`map`**: Преобразует элементы потока по одному и создает поток таких же элементов (например, `Stream<List<T>>` → `Stream<List<R>>`).
- **`flatMap`**: Разворачивает вложенные структуры данных в один поток (например, `Stream<List<T>>` → `Stream<T>`).