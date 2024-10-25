Google предоставляет мощную библиотеку для работы с коллекциями под названием **Guava**. Эта библиотека расширяет стандартные возможности Java, добавляя удобные и эффективные методы для работы с коллекциями. Один из полезных инструментов Guava — это **Partitioning** для деления коллекций на подмножества (или "партии") фиксированного размера, а также множество других утилит для работы с коллекциями.

### 1. **Partitioning List** — Деление списка на подсписки фиксированного размера

- **Описание:** Метод `Lists.partition()` из Guava позволяет разделить список на подсписки заданного размера. Это особенно полезно, если вы хотите обработать большую коллекцию порциями.
- **Пример использования:**

```java
import com.google.common.collect.Lists;
import java.util.List;

public class PartitionExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Делим список на подсписки по 3 элемента
        List<List<Integer>> partitions = Lists.partition(numbers, 3);
        
        for (List<Integer> partition : partitions) {
            System.out.println(partition);
        }
    }
}
```

**Вывод:**
```
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]
[10]
```

### 2. **Multimap** — Хранение нескольких значений для одного ключа

- **Описание:** `Multimap` позволяет ассоциировать один ключ с несколькими значениями. Это похоже на `Map<K, List<V>>`, но более удобно и эффективно.
- **Пример использования:**

```java
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MultimapExample {
    public static void main(String[] args) {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        
        multimap.put("fruit", "apple");
        multimap.put("fruit", "banana");
        multimap.put("vegetable", "carrot");
        
        System.out.println(multimap.get("fruit")); // Выведет [apple, banana]
        System.out.println(multimap.get("vegetable")); // Выведет [carrot]
    }
}
```

### 3. **Immutable Collections** — Невозвращаемые коллекции

- **Описание:** Guava предоставляет утилиты для создания неизменяемых (immutable) коллекций, таких как `ImmutableList`, `ImmutableSet`, и `ImmutableMap`. Это полезно для создания коллекций, которые не должны изменяться после инициализации.
- **Пример использования:**

```java
import com.google.common.collect.ImmutableList;
import java.util.List;

public class ImmutableExample {
    public static void main(String[] args) {
        List<String> immutableList = ImmutableList.of("one", "two", "three");
        
        // Следующая строка бросит исключение UnsupportedOperationException
        // immutableList.add("four");
        
        System.out.println(immutableList);
    }
}
```

### 4. **BiMap** — Двунаправленная карта (би-карта)

- **Описание:** `BiMap` — это двунаправленная карта, которая позволяет находить ключ по значению и наоборот. Полезно, когда требуется поддерживать уникальность как ключей, так и значений.
- **Пример использования:**

```java
import com.google.common.collect.HashBiMap;
import com.google.common.collect.BiMap;

public class BiMapExample {
    public static void main(String[] args) {
        BiMap<String, String> biMap = HashBiMap.create();
        
        biMap.put("apple", "APL");
        biMap.put("banana", "BAN");

        System.out.println(biMap.get("apple")); // Выведет APL
        System.out.println(biMap.inverse().get("BAN")); // Выведет banana
    }
}
```

### 5. **Sets.union(), Sets.intersection(), Sets.difference()** — Операции над множествами

- **Описание:** Guava предоставляет утилиты для объединения (`union`), пересечения (`intersection`) и вычисления разности (`difference`) множеств.
- **Пример использования:**

```java
import com.google.common.collect.Sets;
import java.util.Set;

public class SetsExample {
    public static void main(String[] args) {
        Set<String> set1 = Set.of("apple", "banana", "orange");
        Set<String> set2 = Set.of("banana", "kiwi");

        Set<String> union = Sets.union(set1, set2);
        Set<String> intersection = Sets.intersection(set1, set2);
        Set<String> difference = Sets.difference(set1, set2);

        System.out.println("Union: " + union); // [apple, banana, orange, kiwi]
        System.out.println("Intersection: " + intersection); // [banana]
        System.out.println("Difference: " + difference); // [apple, orange]
    }
}
```

### 6. **Maps.transformValues()** — Преобразование значений в карте

- **Описание:** Этот метод позволяет применить функцию к каждому значению в карте, не изменяя оригинальную карту.
- **Пример использования:**

```java
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.function.Function;

public class TransformValuesExample {
    public static void main(String[] args) {
        Map<String, Integer> originalMap = Map.of("a", 1, "b", 2, "c", 3);

        Map<String, String> transformedMap = Maps.transformValues(originalMap, value -> "Value: " + value);

        System.out.println(transformedMap); // Выведет {a=Value: 1, b=Value: 2, c=Value: 3}
    }
}
```

### 7. **Table** — Двумерная структура данных (таблица)

- **Описание:** `Table` — это структура данных, которая позволяет хранить данные в виде строк и столбцов, подобно таблице. Полезно, если требуется ассоциировать два ключа с одним значением.
- **Пример использования:**

```java
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableExample {
    public static void main(String[] args) {
        Table<String, String, Integer> table = HashBasedTable.create();
        
        table.put("row1", "col1", 1);
        table.put("row1", "col2", 2);
        table.put("row2", "col1", 3);
        
        System.out.println(table.get("row1", "col1")); // Выведет 1
        System.out.println(table.row("row1")); // Выведет {col1=1, col2=2}
    }
}
```

### Подключение Guava через Maven

Для подключения Guava через Maven добавьте следующую зависимость в `pom.xml`:

```xml
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>32.1.2-jre</version>
</dependency>
```
