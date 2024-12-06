### **Ограничения Generics**

Generics предоставляют большую гибкость, но имеют несколько ограничений из-за особенностей реализации в Java. Эти ограничения помогают избежать сложностей, связанных с выполнением кода на этапе компиляции и рантайма.

---

### **1. Примеры ограничений Generics**

#### **1.1. Невозможно создать экземпляры типов (`new T()`)**

Параметры типов в Generics заменяются фактическими типами только на этапе компиляции. В рантайме все типы приводятся к `Object` из-за стирания типов (type erasure). Поэтому создание экземпляра типа `<T>` невозможно.

**Пример:**

```java
public class GenericClass<T> {
    public T createInstance() {
        // return new T(); // Ошибка компиляции: нельзя создать экземпляр типа T
        return null;
    }
}
```

**Причина:**

- Компилятор не знает, какой именно тип заменит `<T>` в рантайме.
- Решение: передавать `Class<T>` как параметр и использовать рефлексию.

**Решение:**

```java
public class GenericClass<T> {
    private final Class<T> type;

    public GenericClass(Class<T> type) {
        this.type = type;
    }

    public T createInstance() throws IllegalAccessException, InstantiationException {
        return type.newInstance();
    }
}

// Использование:
GenericClass<String> genericClass = new GenericClass<>(String.class);
String instance = genericClass.createInstance();
```

---

#### **1.2. Ограничения на примитивы (`List<int>` не разрешено)**

Generics поддерживают только ссылочные типы (`Reference Types`). Примитивные типы, такие как `int`, `double`, нельзя использовать.

**Пример:**

```java
// List<int> list = new ArrayList<>(); // Ошибка компиляции
List<Integer> list = new ArrayList<>(); // Разрешено
```

**Причина:**

- Примитивы не совместимы с типами объектов, используемыми в Generics.

**Решение:**

- Используйте обёрточные классы (`Integer`, `Double`, `Boolean` и т.д.), которые представляют примитивы.

Пример:

```java
List<Integer> intList = List.of(1, 2, 3);
int sum = 0;
for (Integer num : intList) {
    sum += num; // Автоупаковка и автораспаковка (autoboxing/unboxing)
}
System.out.println("Sum: " + sum);
```

---

#### **1.3. Ограничения на статические члены с типом `<T>`**

Generics нельзя использовать в статических контекстах, так как статические члены принадлежат классу, а не его экземпляру. Параметр типа `<T>` связан только с экземпляром класса.

**Пример:**

```java
public class GenericClass<T> {
    private T instance;

    // Нельзя использовать параметр T в статическом поле или методе
    // private static T staticInstance; // Ошибка компиляции

    public static void staticMethod(T param) { // Ошибка компиляции
        System.out.println(param);
    }
}
```

**Причина:**

- Статические члены не зависят от параметров типа, которые определяются на уровне экземпляра класса.

**Решение:**

- Используйте вместо этого обычные типы или передавайте параметр явно.

---

### **2. Решение проблемы с примитивами**

Для работы с примитивами используйте **обёрточные классы** (`Wrapper Classes`), такие как:

- `int` → `Integer`
- `double` → `Double`
- `boolean` → `Boolean`

Эти классы поддерживают автоматическую упаковку и распаковку (autoboxing/unboxing), что делает использование Generics с примитивами удобным.

**Пример:**

```java
List<Integer> intList = List.of(1, 2, 3);
for (Integer num : intList) {
    int value = num; // Автораспаковка
    System.out.println(value);
}
```

**Автоматическая упаковка:**

```java
Integer intObj = 10; // Примитив "10" автоматически упакован в Integer
```

**Автоматическая распаковка:**

```java
int intValue = intObj; // Объект Integer автоматически распакован в примитив
```

---

### **3. Generic и наследование**

Generics не поддерживают ковариантность напрямую. Это означает, что `List<Object>` и `List<String>` не связаны друг с другом, даже если `Object` является суперклассом для `String`.

#### **3.1. Разница между `List<Object>` и `List<?>`**

- `List<Object>`: Эта коллекция принимает **только объекты типа `Object`** или его подклассы, указанные явно.
- `List<?>`: Эта коллекция принимает **любой тип**.

**Пример:**

```java
List<Object> objectList = new ArrayList<>();
objectList.add("String");
objectList.add(123);

List<?> wildcardList = new ArrayList<>();
// wildcardList.add("String"); // Ошибка компиляции
```

**Чтение данных из `List<?>`:** Можно безопасно читать объекты как `Object`:

```java
for (Object obj : wildcardList) {
    System.out.println(obj);
}
```

#### **3.2. Проблема с ковариантностью**

Пример:

```java
List<Object> objectList = new ArrayList<>();
List<String> stringList = new ArrayList<>();
// objectList = stringList; // Ошибка компиляции
```

**Причина:**

- `List<String>` не является подтипом `List<Object>` из-за возможности модификации.

**Решение:** Используйте Wildcards (`<?>`):

```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

---

### **Резюме**

#### **Ограничения:**

1. Невозможно создать экземпляры типов из-за стирания типов.
2. Generics не поддерживают примитивные типы, только ссылочные.
3. Параметры типа нельзя использовать в статических членах.

#### **Решения:**

1. Для создания экземпляров типов используйте `Class<T>` и рефлексию.
2. Для работы с примитивами используйте обёрточные классы.
3. Для универсальных методов и коллекций применяйте Wildcards.
