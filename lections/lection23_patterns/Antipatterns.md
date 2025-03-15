### **4. Антипаттерны проектирования**

Антипаттерны — это **ошибочные практики проектирования**, которые приводят к проблемам в разработке, ухудшают читаемость, поддержку и масштабируемость кода. Разберем **самые распространенные антипаттерны**, которых стоит избегать.

---

## **4.1. God Object (Божественный объект)**
📌 **Описание:**  
Один класс берет на себя **слишком много обязанностей** и **знает слишком много**.

❌ **Плохой пример (Нарушение принципа SRP)**
```java
public class ApplicationManager {
    private List<User> users;
    private List<Order> orders;

    public void createUser(String name) { /* Логика создания пользователя */ }
    public void createOrder(User user) { /* Логика создания заказа */ }
    public void sendNotification(User user) { /* Логика отправки уведомления */ }
    public void saveToDatabase(Object obj) { /* Сохранение в БД */ }
}
```
**Проблема:**
- Класс **занимается всем подряд**: управляет пользователями, заказами, уведомлениями, базой данных.

✅ **Как исправить?**  
Разделить функциональность на **отдельные классы**:
```java
public class UserService { /* Управление пользователями */ }
public class OrderService { /* Управление заказами */ }
public class NotificationService { /* Уведомления */ }
public class DatabaseService { /* Работа с БД */ }
```
Теперь **каждый класс отвечает только за свою зону ответственности**.

---

## **4.2. Spaghetti Code (Спагетти-код)**
📌 **Описание:**  
Код **плохо структурирован**, логика разбросана по всему проекту, а связи между модулями запутаны.

❌ **Плохой пример (Нарушение KISS)**
```java
public class OrderProcessor {
    public void processOrder() {
        System.out.println("Обработка заказа...");
        if (checkStock()) {
            applyDiscount();
            sendEmail();
        } else {
            System.out.println("Нет товара на складе!");
        }
    }

    private boolean checkStock() { return Math.random() > 0.5; }
    private void applyDiscount() { System.out.println("Скидка применена!"); }
    private void sendEmail() { System.out.println("Email отправлен!"); }
}
```
**Проблема:**
- **Вся логика заказа в одном методе**, его трудно читать и тестировать.

✅ **Как исправить?**  
Разделить код по классам и методам:
```java
public class StockService { public boolean isAvailable() { return Math.random() > 0.5; } }
public class DiscountService { public void apply() { System.out.println("Скидка применена!"); } }
public class EmailService { public void send() { System.out.println("Email отправлен!"); } }
public class OrderProcessor {
    public void processOrder() {
        if (new StockService().isAvailable()) {
            new DiscountService().apply();
            new EmailService().send();
        } else {
            System.out.println("Нет товара на складе!");
        }
    }
}
```
Теперь код **структурирован и легко поддерживается**.

---

## **4.3. Singleton Overuse (Чрезмерное использование Singleton)**
📌 **Описание:**  
Чрезмерное использование **паттерна Singleton** может привести к проблемам с тестированием и зависимостями.

❌ **Плохой пример (Неправильное использование Singleton)**
```java
public class Logger {
    private static Logger instance = new Logger();
    private Logger() {}
    public static Logger getInstance() { return instance; }
    public void log(String message) { System.out.println(message); }
}
```
**Проблема:**
- **Жесткая зависимость от глобального состояния**.
- Нельзя **подменить `Logger` в тестах**.

✅ **Как исправить?**  
Использовать **Dependency Injection (DI)**:
```java
public class Logger {
    public void log(String message) { System.out.println(message); }
}
public class OrderService {
    private Logger logger;
    public OrderService(Logger logger) { this.logger = logger; }
    public void processOrder() { logger.log("Заказ обработан"); }
}
```
Теперь можно **заменить `Logger` в тестах** без изменения кода `OrderService`.

---

## **4.4. Lava Flow (Лавовый поток)**
📌 **Описание:**  
В коде остаются **ненужные части, "мертвый код"**, который уже не используется, но никто его не удаляет.

❌ **Плохой пример (Код с ненужными остатками)**
```java
public class PaymentProcessor {
    public void processPayment() {
        // Старый код (больше не нужен, но оставили на всякий случай)
        // processOldPaymentSystem();

        // Новый метод
        processNewPaymentSystem();
    }

    private void processNewPaymentSystem() { System.out.println("Оплата через новую систему"); }
}
```
**Проблема:**
- Старый код **засоряет систему**, его никто не использует, но все боятся удалить.

✅ **Как исправить?**
- **Удалять ненужный код** — он **всегда хранится в Git**, если понадобится.
- Писать **чистый код без "запасов на будущее"**.

---

## **4.5. Golden Hammer (Золотой молоток)**
📌 **Описание:**  
Использование **одного решения для всех проблем**, независимо от того, подходит оно или нет.

❌ **Плохой пример (Singleton везде)**
```java
public class Config {
    private static Config instance = new Config();
    private Config() {}
    public static Config getInstance() { return instance; }
}
```
И каждый сервис **зависит от этого Singleton**:
```java
public class UserService {
    private Config config = Config.getInstance(); // Жесткая привязка
}
```
**Проблема:**
- **Singleton используется даже там, где не нужен**.
- Код сложно **тестировать и менять**.

✅ **Как исправить?**  
Использовать **гибкие решения**, например, Dependency Injection.

---

### **Вывод**
- **God Object** → Разделяйте обязанности между классами.
- **Spaghetti Code** → Держите код чистым и структурированным.
- **Singleton Overuse** → Не злоупотребляйте глобальными состояниями.
- **Lava Flow** → Удаляйте ненужный код.
- **Golden Hammer** → Используйте правильные инструменты для каждой задачи.

