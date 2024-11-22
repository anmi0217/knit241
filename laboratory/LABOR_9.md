# Лабораторная работа № 9
## Цель работы:
- Научиться работать с Enum
- Научиться работать с Аннотациями
- Научиться получать информацию об объекте через Java Reflection

---

### Задача 15: **Времена года**
Создайте Enum для времён года (**Season**). Для каждого времени года укажите:
- Температуру (в виде строки, например, "Холодно", "Тепло").
- Типичный праздник (например, "Новый год" для Winter).

Напишите программу, которая выводит информацию о каждом времени года, используя метод `values()`.

Пример:
```text
Весна: Тепло, типичный праздник - Пасха
Лето: Жарко, типичный праздник - День Независимости
```

### Задача 14: **Цвета светофора**
Создайте Enum **TrafficLight** с состояниями светофора: `RED`, `YELLOW`, `GREEN`. Добавьте метод `getNextLight()`, который возвращает следующее состояние светофора.

Напишите программу, которая:
- Запрашивает текущий сигнал светофора.
- Выводит следующий сигнал.

Пример:
```text
Введите текущий сигнал светофора (RED, YELLOW, GREEN): RED
Следующий сигнал: GREEN
```

---

### Задача 16: **Карты колоды** *
Создайте два Enum:
1. **Suit** для мастей карт (Пики, Черви, Бубны, Трефы).
2. **Rank** для значений карт (2-10, Валет, Дама, Король, Туз).

Напишите программу, которая генерирует стандартную 52-карточную колоду, используя комбинации мастей и значений, и выводит её.

---

### Задача 17: **Валидация полей с помощью аннотаций** *

#### Условие:
Создайте аннотации для валидации значений полей в классе. Реализуйте следующие аннотации:
1. **@NotNull** – Проверяет, чтобы значение поля не было `null`.
2. **@MaxLength(int value)** – Проверяет, чтобы длина строки не превышала заданного значения.
3. **@Min(int value)** – Проверяет, чтобы значение числа не было меньше заданного значения.

Также реализуйте механизм проверки (валидатор), который:
- Читает аннотации из полей класса.
- Проверяет, удовлетворяют ли значения полей указанным условиям.
- Выводит ошибки, если условия не выполнены.

---

#### Пример реализации:

##### Шаг 1: Создание аннотаций
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxLength {
    int value();
}

```

---

##### Шаг 2: Класс с полями
```java
public class User {
    @NotNull
    private String name;

    @MaxLength(10)
    private String username;

    @Min(18)
    private int age;

    // Конструкторы, геттеры и сеттеры
    public User(String name, String username, int age) {
        this.name = name;
        this.username = username;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}
```

---

##### Шаг 3: Реализация валидатора
```java
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            //разрешает доступ к private переменным
            field.setAccessible(true);
            Object value = field.get(obj);

            // Проверка @NotNull
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Поле " + field.getName() + " не должно быть null.");
            }

            // Проверка @MaxLength
            // пример получения значения value из Аннотации
            // int maxLength = field.getAnnotation(MaxLength.class).value();
            /* напишите свою проверку 
                ...
            */
            // Проверка @Min
            /* напишите свою проверку 
                ...
            */ 
        }
    }
}
```

---

##### Шаг 4: Тестирование
```java
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User(null, "LongUsernameHere", 16);

        Validator.validate(user);
    }
}
```

---

#### Ожидаемый вывод:
```text
Поле name не должно быть null.
Поле username превышает максимальную длину 10.
Поле age должно быть не меньше 18.
```

---

### Усложнение:
- Добавьте аннотацию **@Range(min, max)** для проверки диапазона чисел.
- Выбросите собственный Exception унаследованный от класса RuntimeException
