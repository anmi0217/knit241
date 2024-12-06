
#### **Generics в коллекциях**

Generics в коллекциях используются для указания типа элементов, которые могут содержать коллекции (`List`, `Set`, `Map` и другие). Это позволяет избежать ошибок, связанных с преобразованием типов, и сделать код более понятным.

---

##### **1. Коллекции с Generics**

###### **1.1. List**

`List<T>` — это упорядоченная коллекция элементов. Generics позволяют указать тип элементов в списке.

Пример использования:

```java
import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        for (String str : stringList) {
            System.out.println(str); // Нет необходимости в приведении типа
        }

        // stringList.add(123); // Ошибка компиляции: несоответствие типов
    }
}
```

###### **1.2. Set**

`Set<T>` — коллекция, которая не допускает дублирующихся элементов.

Пример:

```java
import java.util.HashSet;
import java.util.Set;

public class GenericsSetExample {
    public static void main(String[] args) {
        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(1); // Дубликаты игнорируются

        for (Integer number : numberSet) {
            System.out.println(number);
        }
    }
}
```

###### **1.3. Map**

`Map<K, V>` — это коллекция пар "ключ-значение". Использование Generics позволяет указать тип ключей и значений.

Пример:

```java
import java.util.HashMap;
import java.util.Map;

public class GenericsMapExample {
    public static void main(String[] args) {
        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Alice", 30);
        ageMap.put("Bob", 25);

        for (Map.Entry<String, Integer> entry : ageMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

---

#### **Объявление обобщённых классов**

Generics позволяют создавать универсальные классы, которые работают с любым типом данных. Такой подход улучшает повторное использование кода.

---

##### **1. Обобщённый класс**

Обобщённый класс — это класс с параметром типа `<T>`, который определяется при использовании класса.

**Пример: класс-контейнер**

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
```

---


##### 4. **Несколько параметров типа**

Классы могут использовать несколько параметров типов. Например, для создания контейнера с парой значений:

```java
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
```

Использование:

```java
public class PairExample {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println(pair.getKey() + ": " + pair.getValue());
    }
}
```
**Результат:**

```
Age: 30
```

---

##### 5. **Ограничения типов**

Generics позволяют задавать ограничения для типов с помощью ключевого слова `extends`.

Пример: создание обобщённого класса, который принимает только числа:

```java
public class NumberBox<T extends Number> {
    private T number;

    public void setNumber(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }
}
```

Использование:

```java
public class BoundedGenericsExample {
    public static void main(String[] args) {
        NumberBox<Integer> intBox = new NumberBox<>();
        intBox.setNumber(123);

        NumberBox<Double> doubleBox = new NumberBox<>();
        doubleBox.setNumber(45.67);

        // NumberBox<String> stringBox = new NumberBox<>(); // Ошибка компиляции
    }
}
```

---

### **Преимущества Generics в коллекциях и классах**

1. **Повышение безопасности типов:** Компилятор проверяет соответствие типов ещё на этапе компиляции, что уменьшает вероятность ошибок времени выполнения.
    
2. **Снижение необходимости приведения типов:** С Generics нет необходимости приводить `Object` к конкретному типу, что делает код чище и проще.
    
3. **Универсальность:** Возможность писать повторно используемые классы и методы, работающие с любыми типами данных.
    

---
