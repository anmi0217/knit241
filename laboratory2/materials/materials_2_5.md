## ✅ Паттерн **Визитер (Visitor)**

### 📌 **Описание:**
Visitor — поведенческий паттерн, который позволяет добавлять новые операции к существующим объектам, не изменяя их структуры.

### 📊 **Схема:**
```
           +------------------+
           |      Visitor      |
           |-------------------|
           | + visit(Element)   |
           +-------------------+
                     ^
                     |
        +------------+------------+
        |                         |
+------------------+    +-------------------+
| ConcreteVisitorA |    | ConcreteVisitorB  |
|------------------|    |-------------------|
| + visit(Element) |    | + visit(Element)  |
+------------------+    +-------------------+

+------------------+
|     Element      |
|------------------|
| + accept(Visitor) |
+------------------+
                     ^
                     |
        +------------+------------+
        |                         |
+------------------+    +-------------------+
|   ElementA       |    |   ElementB        |
|------------------|    |-------------------|
| + accept(Visitor) |    | + accept(Visitor) |
+------------------+    +-------------------+
```

### 📌 **Пример на Java:**
```java
// Элемент интерфейс
interface Element {
    void accept(Visitor visitor);
}

// Конкретные элементы
class ElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Visitor интерфейс
interface Visitor {
    void visit(ElementA elementA);
    void visit(ElementB elementB);
}

// Конкретный посетитель
class ConcreteVisitor implements Visitor {
    public void visit(ElementA elementA) {
        System.out.println("Посетитель работает с ElementA.");
    }

    public void visit(ElementB elementB) {
        System.out.println("Посетитель работает с ElementB.");
    }
}

// Демонстрация
public class VisitorPatternExample {
    public static void main(String[] args) {
        Element[] elements = {new ElementA(), new ElementB()};
        Visitor visitor = new ConcreteVisitor();
        
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
```

---

## ✅ Паттерн **Прокси (Proxy)**

### 📌 **Описание:**
Proxy — структурный паттерн, который предоставляет объект-заместитель, управляющий доступом к другому объекту.

### 📊 **Схема:**
```
              +-----------+
              |   Subject  |
              +-----------+
              | + request()|
              +-----------+
                   ^
                   |
          +--------+--------+
          |                 |
   +--------------+     +-------------+
   | RealSubject  |     | Proxy        |
   |--------------|     |-------------|
   | + request()  |     | + request()  |
   +--------------+     +-------------+
```

### 📌 **Пример на Java:**
```java
// Интерфейс
interface Subject {
    void request();
}

// Реальный объект
class RealSubject implements Subject {
    public void request() {
        System.out.println("Выполнение запроса реального объекта.");
    }
}

// Прокси
class Proxy implements Subject {
    private RealSubject realSubject;

    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        System.out.println("Прокси передает запрос...");
        realSubject.request();
    }
}

// Демонстрация
public class ProxyPatternExample {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.request();
    }
}
```

---

## ✅ Паттерн **Приспособленец (Flyweight)**

### 📌 **Описание:**
Flyweight — структурный паттерн, который позволяет экономить память, разделяя состояние объектов между ними.

### 📊 **Схема:**
```
                       +-------------------+
                       |      Flyweight     |
                       |-------------------|
                       | + operation(state) |
                       +-------------------+
                                 ^
                                 |
           +---------------------+----------------------+
           |                                            |
+---------------------+                     +------------------+
|  ConcreteFlyweight  |                     |  FlyweightFactory |
|---------------------|                     |------------------|
| + operation(state)  |                     | + getFlyweight()  |
+---------------------+                     +------------------+
```

### 📌 **Пример на Java:**
```java
import java.util.HashMap;
import java.util.Map;

// Приспособленец
interface Flyweight {
    void operation(String externalState);
}

// Конкретный приспособленец
class ConcreteFlyweight implements Flyweight {
    private final String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    public void operation(String externalState) {
        System.out.println("Внутреннее состояние: " + intrinsicState + ", Внешнее состояние: " + externalState);
    }
}

// Фабрика приспособленцев
class FlyweightFactory {
    private final Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}

// Демонстрация
public class FlyweightPatternExample {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("A");
        Flyweight flyweight2 = factory.getFlyweight("B");
        Flyweight flyweight3 = factory.getFlyweight("A");

        flyweight1.operation("Первый вызов");
        flyweight2.operation("Второй вызов");
        flyweight3.operation("Третий вызов (тот же объект что и первый)");
    }
}
```
