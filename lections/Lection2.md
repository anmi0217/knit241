# Лекция № 2 

## Цель лекции
- Работа с примитивными типами Java
- класс Object equals и hashcode


#### 1. Примитивные типы данных в Java
Примитивные типы — это базовые типы данных в Java, которые не являются объектами. Они хранятся в стеке и содержат сами значения. Примитивные типы используются для более эффективной работы с памятью.

| Тип       | Размер   | Значение по умолчанию | Диапазон                      |
|-----------|----------|----------------------|-------------------------------|
| `byte`    | 8 бит    | 0                    | -128 до 127                   |
| `short`   | 16 бит   | 0                    | -32,768 до 32,767             |
| `int`     | 32 бита  | 0                    | -2^31 до 2^31-1               |
| `long`    | 64 бита  | 0L                   | -2^63 до 2^63-1               |
| `float`   | 32 бита  | 0.0f                 | примерно ±3.40282347E+38F     |
| `double`  | 64 бита  | 0.0d                 | примерно ±1.7976931348623157E+308 |
| `char`    | 16 бит   | '\u0000'             | '\u0000' (0) до '\uffff' (65535) |
| `boolean` | 1 бит    | false                | true или false                |

#### 2. Обертки над примитивными типами
Для каждого примитивного типа существует соответствующий класс-обертка в пакете `java.lang`. Обертки позволяют работать с примитивами как с объектами, что необходимо в некоторых ситуациях (например, при работе с коллекциями, где допустимы только объекты).

| Примитивный тип | Класс-обертка |
|-----------------|---------------|
| `byte`          | `Byte`        |
| `short`         | `Short`       |
| `int`           | `Integer`     |
| `long`          | `Long`        |
| `float`         | `Float`       |
| `double`        | `Double`      |
| `char`          | `Character`   |
| `boolean`       | `Boolean`     |

##### Пример использования оберток:
```java
int primitiveInt = 5;
Integer wrappedInt = Integer.valueOf(primitiveInt);  // автоупаковка
int unwrappedInt = wrappedInt.intValue();  // автораспаковка
```

#### 3. Разница между float и double
Оба типа данных используются для хранения чисел с плавающей запятой, но различаются точностью и объемом памяти.

- **float**: Одинарная точность, занимает 32 бита, имеет точность примерно до 7 десятичных знаков.
- **double**: Двойная точность, занимает 64 бита, имеет точность примерно до 15 десятичных знаков.

```java
float f = 1.23456789f;  // Требуется суффикс "f"
double d = 1.2345678910111213;
```
Вычисления с `double` более точны, что делает его предпочтительным для работы с высокоточной математикой.

#### 4. Примеры приведения (cast) примитивных типов
Java поддерживает явное и неявное приведение типов. Неявное приведение происходит, если значение может быть безопасно преобразовано, например, из `int` в `long`. Явное приведение требуется, если возможна потеря данных, например, из `double` в `int`.

##### Неявное приведение:
```java
int a = 10;
double b = a;  // int автоматически преобразуется в double
```

##### Явное приведение:
```java
double x = 9.78;
int y = (int) x;  // y станет 9, дробная часть отбрасывается
```

#### 5. Integer Pool (Пул Integer)
Java использует механизм кэширования объектов для чисел типа `Integer`, которые находятся в диапазоне от -128 до 127. Это означает, что для чисел в этом диапазоне Java не создает новый объект, а использует уже существующий. Это помогает экономить память при частом использовании небольших целых чисел.

##### Пример:
```java
Integer a = 127;
Integer b = 127;
System.out.println(a == b);  // true, так как объекты кэшируются

Integer c = 128;
Integer d = 128;
System.out.println(c == d);  // false, так как объекты создаются заново
```

#### 6. Примеры кода для закрепления
1. Автоупаковка и автораспаковка:
```java
Integer wrapped = 100;  // автоупаковка
int primitive = wrapped;  // автораспаковка
```

2. Сравнение `float` и `double`:
```java
float f1 = 1.0f / 3.0f;
double d1 = 1.0 / 3.0;
System.out.println(f1);  // 0.33333334
System.out.println(d1);  // 0.3333333333333333
```

3. Приведение типов:
```java
double myDouble = 9.99;
int myInt = (int) myDouble;
System.out.println(myInt);  // 9
```

4. Проверка Integer Pool:
```java
Integer i1 = 127;
Integer i2 = 127;
System.out.println(i1 == i2);  // true

Integer i3 = 128;
Integer i4 = 128;
System.out.println(i3 == i4);  // false
```
## Пример работы с примитивными типами

Вот несколько примеров работы с примитивными типами в Java, которые помогут лучше понять их использование и основные особенности:

#### 1. Пример работы с типом `int`
```java
public class Main {
    public static void main(String[] args) {
        int a = 5;  // Объявление переменной типа int и присвоение значения
        int b = 10;
        int sum = a + b;  // Операция сложения с типом int
        System.out.println("Сумма: " + sum);  // Вывод результата: 15
    }
}
```

#### 2. Пример работы с типом `double`
```java
public class Main {
    public static void main(String[] args) {
        double pi = 3.14159;  // Объявление переменной типа double
        double radius = 5.5;
        double area = pi * radius * radius;  // Вычисление площади круга
        System.out.println("Площадь круга: " + area);  // Результат: 95.0331775
    }
}
```

#### 3. Пример работы с типом `char`
```java
public class Main {
    public static void main(String[] args) {
        char letter = 'A';  // Пример использования типа char
        char nextLetter = (char) (letter + 1);  // Приведение типа для вычисления следующего символа
        System.out.println("Следующая буква: " + nextLetter);  // Результат: B
    }
}
```

#### 4. Пример работы с типом `boolean`
```java
public class Main {
    public static void main(String[] args) {
        boolean isJavaFun = true;  // Использование типа boolean для логических значений
        boolean isFishTasty = false;

        System.out.println("Java — это весело: " + isJavaFun);  // Результат: true
        System.out.println("Рыба вкусная: " + isFishTasty);  // Результат: false
    }
}
```

#### 5. Пример работы с типом `float` и явного приведения
```java
public class Main {
    public static void main(String[] args) {
        float number = 5.75f;  // Использование суффикса "f" для обозначения float
        int intPart = (int) number;  // Явное приведение float к int
        System.out.println("Целая часть: " + intPart);  // Результат: 5
    }
}
```

#### 6. Пример работы с типом `long`
```java
public class Main {
    public static void main(String[] args) {
        long bigNumber = 12345678910L;  // Использование суффикса "L" для типа long
        System.out.println("Большое число: " + bigNumber);  // Результат: 12345678910
    }
}
```

#### 7. Пример работы с типом `byte`
```java
public class Main {
    public static void main(String[] args) {
        byte smallNumber = 100;  // Значения от -128 до 127
        System.out.println("Маленькое число: " + smallNumber);  // Результат: 100
    }
}
```

#### 8. Пример приведения типов между примитивами
```java
public class Main {
    public static void main(String[] args) {
        int a = 5;
        double b = a;  // Неявное приведение int к double
        System.out.println("Double значение: " + b);  // Результат: 5.0

        double c = 9.99;
        int d = (int) c;  // Явное приведение double к int
        System.out.println("Int значение: " + d);  // Результат: 9
    }
}
```

# Класс Object методы equals и hashCode
В Java все классы наследуются от базового класса `Object`, и два метода, которые он предоставляет — `hashCode()` и `equals()` — играют важную роль в работе с объектами.

### 1. Метод `equals()`

Метод `equals()` используется для сравнения двух объектов на равенство. По умолчанию, реализация `equals()` в классе `Object` проверяет, являются ли два объекта одним и тем же экземпляром (сравнивает ссылки). Это означает, что два объекта считаются равными, если они занимают одно и то же место в памяти.

##### Пример реализации по умолчанию:
```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

Если вы хотите сравнивать объекты по содержимому (например, по значению их полей), вам необходимо переопределить метод `equals()` в вашем классе.

##### Пример переопределения:
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Проверка на сравнение самого объекта с собой
        if (obj == null || getClass() != obj.getClass()) return false;  // Проверка на null и тип объекта

        Person person = (Person) obj;  // Приведение типа
        return age == person.age && name.equals(person.name);  // Сравнение полей
    }
}
```

## Контракт Equals
При переопределении метода `equals()` в Java необходимо соблюдать **контракт equals**, который определяет ряд правил, обеспечивающих корректное поведение метода. Этот контракт описан в спецификации Java и должен соблюдаться для правильного функционирования объектов в различных структурах данных (например, в коллекциях). Вот основные пункты контракта:

### 1. **Рефлексивность** (Reflexivity)
Объект должен быть равен самому себе.

```java
x.equals(x) == true;  // Должно возвращать true
```

### 2. **Симметричность** (Symmetry)
Если объект `x` равен объекту `y`, то и объект `y` должен быть равен объекту `x`.

```java
x.equals(y) == true  // если и только если
y.equals(x) == true;
```

### 3. **Транзитивность** (Transitivity)
Если объект `x` равен объекту `y`, а объект `y` равен объекту `z`, то объект `x` должен быть равен объекту `z`.

```java
if (x.equals(y) == true && y.equals(z) == true) {
    x.equals(z) == true;
}
```

### 4. **Непротиворечивость** (Consistency)
Если объект `x` равен объекту `y`, то этот результат должен быть неизменным, пока объекты не изменяются. То есть, повторные вызовы метода `equals()` на одних и тех же объектах должны всегда возвращать один и тот же результат (если объекты не были изменены).

```java
x.equals(y) == true  // всегда возвращает одно и то же значение при повторных вызовах
```

### 5. **Сравнение с `null`** (Non-nullity)
Любой объект должен быть не равен `null`. Метод `equals()` всегда должен возвращать `false`, если сравнивается с `null`.

```java
x.equals(null) == false;
```

### 6. **Согласованность с `hashCode()`**
Если два объекта равны (согласно `equals()`), они **должны** иметь одинаковые хэш-коды. Это важно для правильной работы в хэш-структурах, таких как `HashMap` и `HashSet`.

```java
if (x.equals(y) == true) {
    x.hashCode() == y.hashCode();  // Должно быть true
}
```

Однако, обратное не обязательно: два объекта могут иметь одинаковые хэш-коды, но при этом не быть равными по `equals()`.

### Пример соблюдения контракта `equals`:
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Рефлексивность
        if (obj == null || getClass() != obj.getClass()) return false;  // Сравнение с null и проверка типа

        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);  // Сравнение полей
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);  // Согласованность с hashCode
    }
}
```

### 2. Метод `hashCode()`

Метод `hashCode()` возвращает целое число (хэш-код), которое используется для эффективного хранения объектов в коллекциях, таких как `HashMap`, `HashSet`, и т. д. Хэш-код объекта помогает быстро определить его местоположение в таких структурах данных.

По умолчанию, реализация метода `hashCode()` в классе `Object` возвращает уникальный хэш-код, основанный на местоположении объекта в памяти. Но если вы переопределяете `equals()`, то вам обязательно нужно переопределить и `hashCode()`, чтобы они согласованно работали вместе. Это правило также называется **контрактом equals и hashCode**:

- Если два объекта равны согласно методу `equals()`, они должны иметь одинаковый хэш-код.
- Если два объекта имеют одинаковый хэш-код, они не обязательно равны (но так чаще всего будет для корректных реализаций).

##### Пример переопределения:
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);  // Генерация хэш-кода на основе значений полей
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }
}
```

### 3. Взаимосвязь методов `equals()` и `hashCode()`

- **Контракт** между `equals()` и `hashCode()` гласит, что если два объекта равны, то они должны иметь одинаковый хэш-код.
- **Пример нарушения контракта**: если вы переопределите `equals()`, но не переопределите `hashCode()`, то объекты, которые кажутся равными с точки зрения `equals()`, могут иметь разные хэш-коды. Это может привести к некорректному поведению при работе с хэш-структурами (например, `HashMap` или `HashSet`).

### 4. Пример использования методов `equals()` и `hashCode()` в коллекциях:
```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John", 25);
        Person person2 = new Person("John", 25);

        HashSet<Person> people = new HashSet<>();
        people.add(person1);
        people.add(person2);

        System.out.println(people.size());  // Если методы equals и hashCode переопределены корректно, результат будет 1
    }
}
```

- **`equals()`**: проверяет равенство объектов. Переопределяется для сравнения объектов по содержимому, а не по ссылке.
- **`hashCode()`**: возвращает хэш-код объекта для эффективного использования в хэш-структурах. Обязательно переопределяется вместе с `equals()`.

Переопределяя оба метода, важно следить за тем, чтобы они корректно выполняли свои задачи и были согласованы между собой, что поможет избежать ошибок в работе с коллекциями и другими структурами данных.


