# **📌 ThreadLocal в Java**
### **Что такое `ThreadLocal`?**
`ThreadLocal<T>` – это механизм, который **позволяет каждому потоку хранить свои уникальные переменные**, недоступные другим потокам.

**🔹 Основные характеристики:**
- **Каждый поток получает собственное значение переменной.**
- **Другие потоки не видят это значение** (каждый поток работает со своей копией).
- **Используется, когда нельзя применять `synchronized`, но нужно изолировать данные для каждого потока.**

📌 **Применение `ThreadLocal`:**  
✔ Логирование (у каждого потока свой ID).  
✔ Соединения с базой данных (у каждого потока свое `Connection`).  
✔ Хранение информации о пользователе в веб-приложениях.

---

## **🔹 Пример 1: Использование `ThreadLocal`**
```java
class ThreadLocalExample {
    private static final ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                threadLocalValue.set(threadLocalValue.get() + 1);
                System.out.println(Thread.currentThread().getName() + " -> " + threadLocalValue.get());
            }
        };

        Thread t1 = new Thread(task, "Поток 1");
        Thread t2 = new Thread(task, "Поток 2");

        t1.start();
        t2.start();
    }
}
```

### **📌 Вывод (пример)**
```
Поток 1 -> 1
Поток 1 -> 2
Поток 1 -> 3
Поток 2 -> 1
Поток 2 -> 2
Поток 2 -> 3
```
✅ Каждый поток имеет **свое отдельное значение** переменной, несмотря на общий `ThreadLocal`.

---

## **🔹 Как это работает?**
Каждый поток хранит переменную в **своем локальном хранилище**, доступном только этому потоку.

🛠 **Без `ThreadLocal` переменная была бы общей, и потоки мешали бы друг другу.**  
⚠ **Важно:** `ThreadLocal` не синхронизирует потоки, но изолирует данные.

---

## **🔹 Пример 2: `ThreadLocal` для хранения ID пользователя**
Допустим, в веб-приложении у нас есть **идентификатор пользователя** (`userId`), и каждый поток должен работать только со "своим" пользователем.

```java
class UserContext {
    private static final ThreadLocal<String> userThreadLocal = new ThreadLocal<>();

    public static void setUser(String user) {
        userThreadLocal.set(user);
    }

    public static String getUser() {
        return userThreadLocal.get();
    }

    public static void clear() {
        userThreadLocal.remove();
    }
}

public class ThreadLocalUserExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            String user = Thread.currentThread().getName().equals("Поток 1") ? "Alice" : "Bob";
            UserContext.setUser(user);

            System.out.println(Thread.currentThread().getName() + " работает с пользователем " + UserContext.getUser());

            UserContext.clear(); // Освобождаем переменную
        };

        Thread t1 = new Thread(task, "Поток 1");
        Thread t2 = new Thread(task, "Поток 2");

        t1.start();
        t2.start();
    }
}
```

### **📌 Вывод**
```
Поток 1 работает с пользователем Alice
Поток 2 работает с пользователем Bob
```
✅ `ThreadLocal` гарантирует, что **каждый поток видит только своего пользователя**.

---

## **🔹 Разновидности `ThreadLocal`**
### **1️⃣ `ThreadLocal.withInitial()`**
Позволяет задать **начальное значение**.

```java
private static final ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 1);
```
☑ **Каждый поток при первом обращении получит `1`.**

---

### **2️⃣ `remove()`**
⚠ **Важно очищать `ThreadLocal`, чтобы избежать утечек памяти!**

```java
threadLocal.remove(); // Удаляет значение из текущего потока
```

---

### **3️⃣ `InheritableThreadLocal`**
Используется, если **поток-потомок** должен унаследовать переменные от родительского потока.

```java
private static final InheritableThreadLocal<String> context = new InheritableThreadLocal<>();
```
☑ Дочерние потоки **наследуют** переменные родителя.

---

## **🔹 Когда использовать `ThreadLocal`?**
✅ Когда **каждому потоку нужны свои данные** (например, текущий пользователь).  
✅ Когда нужно **избежать `synchronized`** (но требуется потоковая изоляция).  
✅ При использовании **баз данных, транзакций, логирования**.

⚠ **Когда НЕ использовать?**
❌ Когда можно **использовать аргументы метода** вместо глобальной переменной.  
❌ Когда нужна **общая переменная для всех потоков** (`ThreadLocal` делает её локальной).  
❌ Если забыть вызвать `remove()`, возможны **утечки памяти**.

---

## **🔹 Вывод**
✅ `ThreadLocal` позволяет **каждому потоку хранить свои данные, изолированные от других потоков**.  
✅ **Используется в логировании, работе с БД, хранении текущего пользователя в веб-приложениях**.  
✅ **Важно очищать `remove()`, чтобы избежать утечек памяти**.
