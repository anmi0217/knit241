### **Wildcards в Java**

**Wildcards** (подстановочные знаки) используются в Generics, чтобы обозначить неизвестный тип. Они особенно полезны, когда необходимо работать с обобщёнными типами, не указывая их точного значения. Wildcards предоставляют гибкость при работе с методами и коллекциями.

---

#### **1. Типы Wildcards**

##### **1.1. `<?>` — неизвестный тип (Unbounded Wildcard)**

`<?>` используется, когда мы хотим указать, что метод или коллекция могут принимать объекты любого типа, но сами типы не имеют значения.

Пример:

```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

Использование:

```java
List<String> stringList = List.of("A", "B", "C");
List<Integer> intList = List.of(1, 2, 3);

printList(stringList); // Вывод: A B C
printList(intList);    // Вывод: 1 2 3
```

**Ограничение:**

- Вы не можете добавлять элементы в коллекцию с `<?>` (кроме `null`), так как тип неизвестен.

---

##### **1.2. `<? extends Type>` — ограничение сверху (Upper Bound Wildcard)**

`<? extends Type>` используется, когда нужно работать с типом `Type` или его подклассами.

Пример:

```java
public void processNumbers(List<? extends Number> numbers) {
    for (Number number : numbers) {
        System.out.println(number);
    }
}
```

Использование:

```java
List<Integer> intList = List.of(1, 2, 3);
List<Double> doubleList = List.of(1.1, 2.2, 3.3);

processNumbers(intList);   // Вывод: 1 2 3
processNumbers(doubleList); // Вывод: 1.1 2.2 3.3
```

**Преимущества:**

- Позволяет безопасно читать элементы, зная, что они наследуются от `Number`.

**Ограничение:**

- Нельзя добавлять элементы в коллекцию с `<? extends Type>`, так как точный тип неизвестен.

---

##### **1.3. `<? super Type>` — ограничение снизу (Lower Bound Wildcard)**

`<? super Type>` используется, когда нужно работать с типом `Type` или его суперклассами.

Пример:

```java
public void addNumbers(List<? super Integer> list) {
    list.add(42); // Добавление допустимо
}
```

Использование:

```java
List<Object> objList = new ArrayList<>();
addNumbers(objList); // Работает

List<Number> numList = new ArrayList<>();
addNumbers(numList); // Работает
```

**Преимущества:**

- Позволяет безопасно добавлять элементы определённого типа или его подклассов.

**Ограничение:**

- Нельзя безопасно читать элементы из коллекции (кроме `Object`), так как точный тип неизвестен.

---

#### **2. Примеры использования Wildcards**

##### **2.1. Чтение из коллекций с `<? extends Type>`**

Если коллекция объявлена с использованием `<? extends Type>`, можно безопасно читать элементы, но нельзя добавлять новые.

Пример:

```java
public double sumNumbers(List<? extends Number> numbers) {
    double sum = 0;
    for (Number number : numbers) {
        sum += number.doubleValue();
    }
    return sum;
}
```

Использование:

```java
List<Integer> intList = List.of(1, 2, 3);
System.out.println("Sum: " + sumNumbers(intList)); // Вывод: Sum: 6.0
```

---

##### **2.2. Запись в коллекции с `<? super Type>`**

Если коллекция объявлена с использованием `<? super Type>`, можно безопасно добавлять элементы, но чтение ограничено объектами типа `Object`.

Пример:

```java
public void fillList(List<? super Integer> list) {
    list.add(1);
    list.add(2);
    list.add(3);
}
```

Использование:

```java
List<Number> numList = new ArrayList<>();
fillList(numList);
System.out.println(numList); // Вывод: [1, 2, 3]
```

---

##### **2.3. Коллекции с `<?>`**

Если вы хотите обработать коллекцию любого типа, используйте `<?>`.

Пример:

```java
public void printElements(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

---

#### **3. Когда использовать Wildcards?**

##### **3.1. Используйте `<? extends Type>` для чтения**

Если метод только **читает данные** из коллекции, используйте `<? extends Type>`.

Пример:

```java
public void displayNumbers(List<? extends Number> numbers) {
    for (Number number : numbers) {
        System.out.println(number);
    }
}
```

##### **3.2. Используйте `<? super Type>` для записи**

Если метод только **записывает данные** в коллекцию, используйте `<? super Type>`.

Пример:

```java
public void addIntegers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}
```

##### **3.3. Используйте `<?>`, если тип не имеет значения**

Если метод **не изменяет коллекцию**, а просто её обрабатывает, используйте `<?>`.

Пример:

```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

---

### **Сводная таблица**

|Wildcard|Чтение из коллекции|Запись в коллекцию|Когда использовать|
|---|---|---|---|
|`<?>`|✅ (Object)|❌|Обработка любого типа|
|`<? extends Type>`|✅ (Type и его подклассы)|❌|Чтение данных|
|`<? super Type>`|❌ (кроме Object)|✅ (Type и его подклассы)|Добавление данных|

---

### **Резюме**

- **`<?>`**: Для коллекций с неизвестным типом, когда не требуется изменять содержимое.
- **`<? extends Type>`**: Для чтения данных, ограниченных определённым типом или его подклассами.
- **`<? super Type>`**: Для записи данных, ограниченных определённым типом или его суперклассами.

