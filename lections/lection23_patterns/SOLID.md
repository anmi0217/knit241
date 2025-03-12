### **2. Принципы SOLID**

**SOLID** — это пять фундаментальных принципов объектно-ориентированного проектирования, предложенных **Робертом Мартином (Robert C. Martin)**. Эти принципы помогают **создавать гибкий, поддерживаемый и расширяемый код**, а также избегать распространенных ошибок проектирования.

---

## **2.1. S — Single Responsibility Principle (Принцип единственной ответственности)**
**Каждый класс должен иметь только одну причину для изменения.**

👉 **Плохой пример (Нарушение SRP)**
```java
public class Order {
    public void calculateTotal() { /* Логика расчета суммы */ }
    public void printOrder() { /* Логика вывода заказа */ }
    public void saveToDatabase() { /* Логика сохранения в БД */ }
}
```
**Проблема:**
- Класс **Order** отвечает сразу за бизнес-логику, вывод данных и работу с БД.
- Если изменится способ хранения заказов — нужно будет изменять этот класс.

✅ **Хороший пример (SRP в действии)**
```java
public class Order {
    public void calculateTotal() { /* Логика расчета суммы */ }
}

public class OrderPrinter {
    public void printOrder(Order order) { /* Логика вывода заказа */ }
}

public class OrderRepository {
    public void saveToDatabase(Order order) { /* Логика сохранения */ }
}
```
Теперь:
- **Order** занимается только бизнес-логикой.
- **OrderPrinter** отвечает за вывод данных.
- **OrderRepository** отвечает за работу с базой данных.

---

## **2.2. O — Open/Closed Principle (Принцип открытости/закрытости)**
**Классы должны быть открыты для расширения, но закрыты для модификации.**

👉 **Плохой пример (Нарушение OCP)**  
Допустим, у нас есть система скидок, где мы определяем тип скидки в `if-else`:
```java
public class DiscountService {
    public double applyDiscount(double price, String discountType) {
        if (discountType.equals("NEWYEAR")) {
            return price * 0.9;
        } else if (discountType.equals("BLACKFRIDAY")) {
            return price * 0.8;
        }
        return price;
    }
}
```
**Проблема:**
- Если добавится новый тип скидки, придется **изменять существующий код**.
- Это приведет к потенциальным багам.

✅ **Хороший пример (OCP в действии)**  
Используем **полиморфизм**:
```java
public interface Discount {
    double apply(double price);
}

public class NewYearDiscount implements Discount {
    public double apply(double price) {
        return price * 0.9;
    }
}

public class BlackFridayDiscount implements Discount {
    public double apply(double price) {
        return price * 0.8;
    }
}

public class DiscountService {
    public double applyDiscount(double price, Discount discount) {
        return discount.apply(price);
    }
}
```
Теперь можно добавлять новые виды скидок **без изменения кода `DiscountService`**.

---

## **2.3. L — Liskov Substitution Principle (Принцип подстановки Лисков)**
**Объекты наследуемых классов должны полностью заменять объекты базового класса без изменения поведения программы.**

👉 **Плохой пример (Нарушение LSP)**
```java
public class Rectangle {
    protected int width, height;

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    public int getArea() { return width * height; }
}

public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // !!! Нарушение LSP
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height; // !!! Нарушение LSP
    }
}
```
**Проблема:**
- **Квадрат не может корректно заменить прямоугольник** — изменение одной стороны должно изменять и другую, что ломает логику `Rectangle`.

✅ **Хороший пример (Исправленный код)**  
Лучше создать **отдельные классы**, а не наследовать `Square` от `Rectangle`:
```java
public interface Shape {
    int getArea();
}

public class Rectangle implements Shape {
    protected int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

public class Square implements Shape {
    protected int side;

    public Square(int side) {
        this.side = side;
    }

    public int getArea() {
        return side * side;
    }
}
```
Теперь **каждый класс работает независимо** и не ломает принцип подстановки.

---

## **2.4. I — Interface Segregation Principle (Принцип разделения интерфейсов)**
**Не заставляйте клиентов зависеть от методов, которые они не используют.**

👉 **Плохой пример (Нарушение ISP)**
```java
public interface Worker {
    void work();
    void eat();
}
public class Robot implements Worker {
    public void work() { System.out.println("Работаю"); }
    public void eat() { throw new UnsupportedOperationException("Робот не ест!"); } // !!! Нарушение
}
```
**Проблема:**
- Роботы **не едят**, но из-за интерфейса **должны реализовывать метод eat()**.

✅ **Хороший пример (ISP в действии)**  
Разделим интерфейсы:
```java
public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public class Human implements Workable, Eatable {
    public void work() { System.out.println("Работаю"); }
    public void eat() { System.out.println("Обедаю"); }
}

public class Robot implements Workable {
    public void work() { System.out.println("Работаю"); }
}
```
Теперь каждый класс реализует **только нужные ему методы**.

---

## **2.5. D — Dependency Inversion Principle (Принцип инверсии зависимостей)**
**Модули верхнего уровня не должны зависеть от модулей нижнего уровня. Оба должны зависеть от абстракций.**

👉 **Плохой пример (Нарушение DIP)**
```java
public class LightBulb {
    public void turnOn() { System.out.println("Лампочка включена"); }
    public void turnOff() { System.out.println("Лампочка выключена"); }
}

public class Switch {
    private LightBulb bulb = new LightBulb(); // Жесткая зависимость

    public void operate() {
        bulb.turnOn();
    }
}
```
**Проблема:**
- Если нужно заменить лампочку на светодиод, придется **менять код класса Switch**.

✅ **Хороший пример (DIP в действии)**
```java
public interface Switchable {
    void turnOn();
    void turnOff();
}

public class LightBulb implements Switchable {
    public void turnOn() { System.out.println("Лампочка включена"); }
    public void turnOff() { System.out.println("Лампочка выключена"); }
}

public class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}
```
Теперь можно подставить **любой источник света**, не меняя код `Switch`.

---

🔹 **Вывод:**  
**SOLID помогает писать чистый, поддерживаемый код**. Если их соблюдать, система становится гибче и проще в расширении. 🚀
