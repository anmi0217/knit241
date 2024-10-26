### 6. Часто используемые методы из класса `Collections` (15 минут)

Класс `Collections` в Java предоставляет множество статических методов для работы с коллекциями. Эти методы упрощают задачи, такие как сортировка, создание неизменяемых коллекций, и многие другие операции, которые часто встречаются при работе с данными. Давайте подробно рассмотрим некоторые из наиболее часто используемых методов.

#### 6.1 Сортировка коллекций: `Collections.sort()`

Метод `Collections.sort()` используется для сортировки списков (`List`) на основе естественного порядка элементов или с использованием компараторов.

##### Пример 1: Сортировка списка с естественным порядком
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);

        Collections.sort(numbers); // Сортировка по естественному порядку
        System.out.println(numbers); // [1, 2, 3, 4]
    }
}
```
**Объяснение:** В этом примере список целых чисел сортируется по возрастанию, что является их естественным порядком.

##### Пример 2: Сортировка с использованием компаратора
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Collections.sort(names, Comparator.reverseOrder()); // Сортировка в обратном порядке
        System.out.println(names); // [Charlie, Bob, Alice]
    }
}
```
**Объяснение:** Здесь используется компаратор для сортировки строк в обратном порядке.

#### 6.2 Создание неизменяемых и пустых коллекций

Класс `Collections` предоставляет методы для создания неизменяемых и пустых коллекций. Это полезно, когда нужно передать пустую коллекцию или создать коллекцию, которую нельзя модифицировать.

##### `Collections.singletonList(element)`
- Создает список, содержащий только один элемент.
- Неизменяемый список, попытка изменить его вызовет `UnsupportedOperationException`.

```java
import java.util.Collections;
import java.util.List;

public class SingletonListExample {
    public static void main(String[] args) {
        List<String> singleItemList = Collections.singletonList("Single");
        System.out.println(singleItemList); // [Single]
        // singleItemList.add("Another"); // Ошибка UnsupportedOperationException
    }
}
```

##### `Collections.emptyList()`, `Collections.emptySet()`, `Collections.emptyMap()`
- Возвращают пустую неизменяемую коллекцию.
- Полезны, когда нужно передать пустую коллекцию без необходимости создавать новый объект.

```java
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class EmptyCollectionExample {
    public static void main(String[] args) {
        List<String> emptyList = Collections.emptyList();
        Set<Integer> emptySet = Collections.emptySet();

        System.out.println(emptyList); // []
        System.out.println(emptySet); // []
    }
}
```

#### 6.3 Другие полезные методы

##### `Collections.reverse()`
- Разворачивает порядок элементов в списке.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Collections.reverse(numbers);
        System.out.println(numbers); // [3, 2, 1]
    }
}
```

##### `Collections.shuffle()`
- Перемешивает элементы списка случайным образом.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Collections.shuffle(numbers);
        System.out.println(numbers); // [2, 1, 3] (порядок может меняться)
    }
}
```

##### `Collections.max()` и `Collections.min()`
- Определяют максимальный и минимальный элемент в коллекции.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxMinExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Max: " + max + ", Min: " + min); // Max: 4, Min: 1
    }
}
```

#### 6.4 Особенности `Collections.unmodifiableList()` и другие методы создания неизменяемых коллекций

Методы `Collections.unmodifiableList()`, `Collections.unmodifiableSet()`, `Collections.unmodifiableMap()` позволяют создать "обертку" вокруг существующей коллекции, делая её неизменяемой. Попытка изменить такую коллекцию вызовет `UnsupportedOperationException`.

##### Пример:
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableListExample {
    public static void main(String[] args) {
        List<String> modifiableList = new ArrayList<>();
        modifiableList.add("Item 1");
        modifiableList.add("Item 2");

        List<String> unmodifiableList = Collections.unmodifiableList(modifiableList);
        System.out.println(unmodifiableList); // [Item 1, Item 2]

        // Попытка добавить элемент вызовет исключение
        // unmodifiableList.add("New Item"); // Ошибка UnsupportedOperationException
    }
}
```

**Объяснение:**
- Мы создаем изменяемый список и затем делаем его неизменяемым с помощью `Collections.unmodifiableList()`.
- Любая попытка модифицировать такой список, например, добавить или удалить элемент, приведет к выбросу `UnsupportedOperationException`.

**Преимущества:**
- **Защита данных:** Позволяет защитить коллекцию от непреднамеренных или вредоносных изменений.
- **Гибкость:** Можно создать коллекцию, которая изменяется только в контролируемых местах кода.

**Ограничения:**
- Эти методы создают лишь обертку вокруг коллекции. Если исходная коллекция (в данном примере `modifiableList`) изменится, то изменения отразятся и в неизменяемой коллекции (`unmodifiableList`), так как они ссылаются на один и тот же объект.