
#### **Что такое Enum и когда его использовать?**

`enum` (enumeration) в Java – это специальный тип данных, который представляет собой набор заранее определённых констант. Его используют, когда нужно ограничить значения переменной конкретным набором.

Примеры использования:

1. Дни недели (`Monday`, `Tuesday` и т. д.).
2. Состояния (`STARTED`, `RUNNING`, `FINISHED`).
3. Направления (`NORTH`, `SOUTH`, `EAST`, `WEST`).

---

### **Методы Enum**

1. **`values()`**
    
    - Возвращает массив всех элементов перечисления.
    - Пример:
        
        ```java
        for (Day day : Day.values()) {
            System.out.println(day);
        }
        ```
        
2. **`valueOf(String)`**
    
    - Преобразует строку в элемент перечисления.
    - Если строка не соответствует ни одной константе, выбрасывается `IllegalArgumentException`.
    - Пример:
        
        ```java
        Day day = Day.valueOf("MONDAY");
        System.out.println(day); // Вывод: MONDAY
        ```
        
3. **`ordinal()`**
    
    - Возвращает порядковый номер элемента (начинается с `0`).
    - Пример:
        
        ```java
        System.out.println(Day.MONDAY.ordinal()); // Вывод: 0
        ```
        

---

### **Добавление полей и методов в Enum**

Перечисления в Java могут содержать:

- **Поля**: для хранения данных.
- **Методы**: для обработки данных.
- **Конструкторы**: для инициализации полей (всегда `private`).

#### Пример:

```java
enum Day {
    MONDAY("Workday"),
    TUESDAY("Workday"),
    SATURDAY("Weekend"),
    SUNDAY("Weekend");

    private final String type; // Поле для хранения типа дня

    // Конструктор (должен быть private)
    Day(String type) {
        this.type = type;
    }

    // Метод для доступа к полю
    public String getType() {
        return type;
    }
}

public class Main {
    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println(day + " is a " + day.getType());
        }
    }
}
```

**Вывод:**

```
MONDAY is a Workday
TUESDAY is a Workday
SATURDAY is a Weekend
SUNDAY is a Weekend
```

---

### **Реализация интерфейсов с помощью Enum**

Перечисления могут реализовывать интерфейсы, чтобы предоставить одинаковое поведение для всех элементов.

#### Пример:

```java
interface Printable {
    void print();
}

enum Level implements Printable {
    HIGH {
        @Override
        public void print() {
            System.out.println("High level");
        }
    },
    MEDIUM {
        @Override
        public void print() {
            System.out.println("Medium level");
        }
    },
    LOW {
        @Override
        public void print() {
            System.out.println("Low level");
        }
    };
}

public class Main {
    public static void main(String[] args) {
        for (Level level : Level.values()) {
            level.print();
        }
    }
}
```

**Вывод:**

```
High level
Medium level
Low level
```

---

### **Ключевые примеры**

#### Простой Enum для дней недели

```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class Main {
    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println(day);
        }
    }
}
```

**Вывод:**

```
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
SATURDAY
SUNDAY
```

---

#### Enum с полями и методами для расширенного функционала

```java
enum Status {
    ACTIVE("User is active"),
    INACTIVE("User is inactive"),
    BANNED("User is banned");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class Main {
    public static void main(String[] args) {
        Status status = Status.ACTIVE;
        System.out.println(status + ": " + status.getDescription());
    }
}
```

**Вывод:**

```
ACTIVE: User is active
```

---

### **Итоги**

- `enum` помогает задавать фиксированные наборы значений, улучшая читаемость и безопасность кода.
- Методы `values()`, `valueOf(String)` и `ordinal()` позволяют работать с перечислениями.
- Enum может содержать поля, методы и конструкторы для дополнительного функционала.
- Реализация интерфейсов позволяет добавлять специфическое поведение к элементам.

